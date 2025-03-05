package org.shadcn.postsvc.service;

import java.util.List;

import org.shadcn.postsvc.dto.request.CreateCommentRequest;
import org.shadcn.postsvc.dto.request.UpdateCommentRequest;
import org.shadcn.postsvc.dto.response.CommentResponse;

public interface ICommentService {
    void createComment(CreateCommentRequest request);

    CommentResponse getCommentById(Long commentId);

    List<CommentResponse> getCommentsByPostId(Long postId);

    List<CommentResponse> getRepliesByCommentId(Long parentId);

    void updateComment(Long commentId, UpdateCommentRequest request);

    void deleteComment(Long commentId);
}
