package org.shadcn.postsvc.service;

import org.shadcn.postsvc.dto.request.CreatePostRequest;
import org.shadcn.postsvc.dto.request.UpdatePostRequest;
import org.shadcn.postsvc.dto.response.PageResponse;
import org.shadcn.postsvc.dto.response.PostDetailResponse;
import org.shadcn.postsvc.dto.response.PostResponse;
import org.shadcn.postsvc.enums.Status;

public interface IPostService {

    void createPost(CreatePostRequest request);

    PostDetailResponse getPostDetailById(Long postId);

    PageResponse<PostResponse> getAllPosts(int current, int pageSize);

    void updatePost(Long postId, UpdatePostRequest request);

    void deletePost(Long postId);

    PageResponse<PostResponse> getAllPostsByAuthor(Long authorId, int current, int pageSize);

    void increaseHotScore(Long postId, double score);

    void changePostStatus(Long postId, Status status);
}
