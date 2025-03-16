package org.shadcn.postsvc.controller;

import static org.shadcn.postsvc.constant.PathConstant.API_V1_POSTS;

import java.util.Set;

import org.shadcn.postsvc.dto.request.CreatePostRequest;
import org.shadcn.postsvc.dto.request.UpdatePostRequest;
import org.shadcn.postsvc.dto.response.ApiResponse;
import org.shadcn.postsvc.dto.response.PageResponse;
import org.shadcn.postsvc.dto.response.PostDetailResponse;
import org.shadcn.postsvc.dto.response.PostResponse;
import org.shadcn.postsvc.enums.Status;
import org.shadcn.postsvc.service.IPostService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(API_V1_POSTS)
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PostController {
    IPostService postService;

    @PostMapping(value = "create-web-post")
    public ApiResponse<Void> createWebPost(@RequestBody CreatePostRequest request) {
        postService.createWebPost(request);
        return ApiResponse.success(null);
    }

    @PostMapping(value = "create-post", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ApiResponse<Void> createPost(
            @RequestPart String request, @RequestPart(value = "thumbnail", required = false) MultipartFile thumbnail)
            throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CreatePostRequest data = objectMapper.readValue(request, CreatePostRequest.class);
        postService.createPost(data, thumbnail);
        return ApiResponse.success(null);
    }

    @GetMapping("/{postId}")
    public ApiResponse<PostDetailResponse> getPostDetailById(@PathVariable Long postId) {
        PostDetailResponse postResponse = postService.getPostDetailById(postId);
        return ApiResponse.success(postResponse);
    }

    @GetMapping()
    public ApiResponse<PageResponse<PostResponse>> getAllPost(
            @RequestParam(defaultValue = "1", required = false) Integer current,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return ApiResponse.success(postService.getAllPosts(current, pageSize));
    }

    @PutMapping("/{postId}")
    public ApiResponse<Void> updatePost(@PathVariable Long postId, @RequestBody UpdatePostRequest request) {
        postService.updatePost(postId, request);
        return ApiResponse.success(null);
    }

    @DeleteMapping("/{postId}")
    public ApiResponse<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ApiResponse.success(null);
    }

    @GetMapping("/author/{userId}")
    public ApiResponse<PageResponse<PostResponse>> getAllPostsByAuthor(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "1", required = false) int current,
            @RequestParam(defaultValue = "10", required = false) int pageSize) {
        return ApiResponse.success(postService.getAllPostsByAuthor(userId, current, pageSize));
    }

    @PatchMapping("/{postId}/increase-hot-score")
    public ApiResponse<Void> increaseHotScore(@PathVariable Long postId, @RequestParam double score) {
        postService.increaseHotScore(postId, score);
        return ApiResponse.success(null);
    }

    @PatchMapping("/{postId}/change-status")
    public ApiResponse<Void> changePostStatus(@PathVariable Long postId, @RequestParam Status status) {
        postService.changePostStatus(postId, status);
        return ApiResponse.success(null);
    }

    @GetMapping("/find-by-tags")
    public ApiResponse<PageResponse<PostResponse>> findByTags(
            @RequestParam Set<String> tags,
            @RequestParam(defaultValue = "1", required = false) int current,
            @RequestParam(defaultValue = "10", required = false) int pageSize) {
        return ApiResponse.success(postService.findByTags(tags, current, pageSize));
    }

    @GetMapping("/find-by-author/{authorId}")
    public ApiResponse<PageResponse<PostResponse>> findByAuthor(
            @PathVariable Long authorId,
            @RequestParam(defaultValue = "1", required = false) int current,
            @RequestParam(defaultValue = "10", required = false) int pageSize) {
        return ApiResponse.success(postService.getAllPostsByAuthor(authorId, current, pageSize));
    }
}
