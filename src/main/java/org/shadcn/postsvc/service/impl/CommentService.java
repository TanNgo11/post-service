package org.shadcn.postsvc.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.shadcn.postsvc.dto.request.CreateCommentRequest;
import org.shadcn.postsvc.dto.request.UpdateCommentRequest;
import org.shadcn.postsvc.dto.response.CommentResponse;
import org.shadcn.postsvc.service.ICommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class CommentService implements ICommentService {
    @Override
    public CommentResponse createComment(CreateCommentRequest request) {
        return null;
    }

    @Override
    public CommentResponse getCommentById(Long commentId) {
        return null;
    }

    @Override
    public List<CommentResponse> getCommentsByPostId(Long postId) {
        return List.of();
    }

    @Override
    public List<CommentResponse> getRepliesByCommentId(Long parentId) {
        return List.of();
    }

    @Override
    public CommentResponse updateComment(Long commentId, UpdateCommentRequest request) {
        return null;
    }

    @Override
    public void deleteComment(Long commentId) {

    }
}
