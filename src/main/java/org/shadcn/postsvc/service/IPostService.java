package org.shadcn.postsvc.service;

import org.shadcn.postsvc.dto.request.CreatePostRequest;
import org.shadcn.postsvc.dto.request.UpdatePostRequest;
import org.shadcn.postsvc.dto.response.PageResponse;
import org.shadcn.postsvc.dto.response.PostResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPostService {

    PostResponse createPost(CreatePostRequest request);

    PostResponse getPostById(Long postId);

    List<PostResponse> getAllPosts();

    PageResponse<PostResponse> getPagedPosts(int current, int pageSize);

    PostResponse updatePost(Long postId, UpdatePostRequest request);

    void deletePost(Long postId);

    List<PostResponse> getPostsByUser(Long userId);

    void increaseHotScore(Long postId, double score);
}