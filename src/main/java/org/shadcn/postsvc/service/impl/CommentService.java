package org.shadcn.postsvc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import org.shadcn.postsvc.dto.request.CreateCommentRequest;
import org.shadcn.postsvc.dto.request.UpdateCommentRequest;
import org.shadcn.postsvc.dto.response.CommentResponse;
import org.shadcn.postsvc.entity.Comment;
import org.shadcn.postsvc.entity.Post;
import org.shadcn.postsvc.exception.AppException;
import org.shadcn.postsvc.exception.ErrorCode;
import org.shadcn.postsvc.mapper.CommentMapper;
import org.shadcn.postsvc.repository.CommentRepository;
import org.shadcn.postsvc.repository.PostRepository;
import org.shadcn.postsvc.repository.httpClient.IdentityClient;
import org.shadcn.postsvc.service.ICommentService;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CommentService implements ICommentService {
    CommentRepository commentRepository;
    CommentMapper commentMapper;
    IdentityClient identityClient;
    PostRepository postRepository;

    @Override
    public void createComment(CreateCommentRequest request) {
        Post post = postRepository
                .findById(request.getPostId())
                .orElseThrow(() -> new AppException(ErrorCode.POST_NOT_EXISTED));

        Comment comment = commentMapper.toComment(request);
        comment.setPost(post);

        if (request.getParentId() != null) {
            Comment parent = commentRepository
                    .findById(request.getParentId())
                    .orElseThrow(() -> new AppException(ErrorCode.COMMENT_NOT_EXISTED));
            comment.setParent(parent);
        }
        commentRepository.save(comment);
    }

    @Override
    public CommentResponse getCommentById(Long commentId) {
        return null;
    }

    @Override
    public List<CommentResponse> getCommentsByPostId(Long postId) {
        if (postId == null) {
            throw new IllegalArgumentException("Post ID cannot be null");
        }
        List<Comment> comments = commentRepository.findByPostIdAndParentId(postId, null);
        return comments.stream().map(commentMapper::toCommentResponse).collect(Collectors.toList());
    }

    @Override
    public List<CommentResponse> getRepliesByCommentId(Long parentId) {
        return List.of();
    }

    @Override
    @Transactional
    public void updateComment(Long commentId, UpdateCommentRequest request) {
        Comment comment = commentRepository
                .findById(commentId)
                .orElseThrow(() -> new AppException(ErrorCode.COMMENT_NOT_EXISTED));

        Date now = new Date();

        long thirtyMinutesInMillis = 30 * 60 * 1000; // 30 phút = 1800000 ms
        Date deadline = new Date(comment.getCreatedDate().getTime() + thirtyMinutesInMillis);

        if (now.after(deadline)) {
            throw new AppException(ErrorCode.COMMENT_EXPIRED);
        }
        comment.setContent(request.getContent());
        comment.setModifiedDate(now);
        comment.setModifiedBy(request.getModifiedBy());
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Long commentId) {
        Comment comment = commentRepository
                .findById(commentId)
                .orElseThrow(() -> new AppException(ErrorCode.COMMENT_NOT_EXISTED));
        markAsDeleted(comment);
        commentRepository.save(comment);
    }

    private void markAsDeleted(Comment comment) {
        comment.setDeleted(true);
        for (Comment reply : comment.getReplies()) {
            markAsDeleted(reply);
        }
    }
}
