package org.shadcn.postsvc.service;

import org.shadcn.postsvc.dto.request.CreateCommentRequest;
import org.shadcn.postsvc.dto.request.UpdateCommentRequest;
import org.shadcn.postsvc.dto.response.CommentResponse;

import java.util.List;

public interface ICommentService {
    CommentResponse createComment(CreateCommentRequest request); // Tạo comment

    CommentResponse getCommentById(Long commentId); // Lấy comment theo ID

    List<CommentResponse> getCommentsByPostId(Long postId); // Lấy comment theo bài viết

    List<CommentResponse> getRepliesByCommentId(Long parentId); // Lấy danh sách reply của 1 comment

    CommentResponse updateComment(Long commentId, UpdateCommentRequest request); // Cập nhật comment

    void deleteComment(Long commentId); // Xóa comment (soft delete)
}