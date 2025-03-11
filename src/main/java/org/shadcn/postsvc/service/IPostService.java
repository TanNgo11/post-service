package org.shadcn.postsvc.service;

import java.util.Set;

import org.shadcn.postsvc.dto.request.CreatePostRequest;
import org.shadcn.postsvc.dto.request.UpdatePostRequest;
import org.shadcn.postsvc.dto.response.PageResponse;
import org.shadcn.postsvc.dto.response.PostDetailResponse;
import org.shadcn.postsvc.dto.response.PostResponse;
import org.shadcn.postsvc.enums.Status;
import org.springframework.web.multipart.MultipartFile;

public interface IPostService {

    void createPost(CreatePostRequest request, MultipartFile thumbnail);

    PostDetailResponse getPostDetailById(Long postId);

    PageResponse<PostResponse> getAllPosts(int current, int pageSize);

    void updatePost(Long postId, UpdatePostRequest request);

    void deletePost(Long postId);

    PageResponse<PostResponse> getAllPostsByAuthor(Long authorId, int current, int pageSize);

    void increaseHotScore(Long postId, double score);

    void changePostStatus(Long postId, Status status);

    PageResponse<PostResponse> findByTags(Set<String> tag, int current, int pageSize);
}
