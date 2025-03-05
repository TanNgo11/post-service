package org.shadcn.postsvc.controller;

import static org.shadcn.postsvc.constant.PathConstant.API_V1_COMMENT;

import java.util.List;

import org.hibernate.sql.Update;
import org.shadcn.postsvc.dto.request.CreateCommentRequest;
import org.shadcn.postsvc.dto.request.UpdateCommentRequest;
import org.shadcn.postsvc.dto.response.ApiResponse;
import org.shadcn.postsvc.dto.response.CommentResponse;
import org.shadcn.postsvc.service.ICommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(API_V1_COMMENT)
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommentController {
    ICommentService commentService;

    @PostMapping("/create-comment")
    public ApiResponse<Void> createComment(@RequestBody CreateCommentRequest request) {
        commentService.createComment(request);
        return ApiResponse.success(null);
    }

    @GetMapping("/{postId}")
    public ApiResponse<List<CommentResponse>> getCommentById(@PathVariable Long postId) {
        return ApiResponse.success(commentService.getCommentsByPostId(postId));
    }

    @DeleteMapping("/{commentId}")
    public ApiResponse<Void> deleteComment(@PathVariable Long commentId) {
        log.info("Received request to delete comment: {}", commentId);
        commentService.deleteComment(commentId);
        return ApiResponse.success(null);

    }

    @PutMapping("/{commentId}")
    public ApiResponse<Void> updateComment(@PathVariable Long commentId, @RequestBody UpdateCommentRequest request) {
        commentService.updateComment(commentId, request);
        return ApiResponse.success(null);
    }

}
