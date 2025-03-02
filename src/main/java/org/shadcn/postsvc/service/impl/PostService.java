package org.shadcn.postsvc.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.shadcn.postsvc.dto.request.CreatePostRequest;
import org.shadcn.postsvc.dto.request.UpdatePostRequest;
import org.shadcn.postsvc.dto.response.PageResponse;
import org.shadcn.postsvc.dto.response.PostResponse;
import org.shadcn.postsvc.service.IPostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PostService implements IPostService {
    @Override
    public PostResponse createPost(CreatePostRequest request) {
        return null;
    }

    @Override
    public PostResponse getPostById(Long postId) {
        return null;
    }

    @Override
    public List<PostResponse> getAllPosts() {
        return List.of();
    }

    @Override
    public PageResponse<PostResponse> getPagedPosts(int current, int pageSize) {
        return null;
    }

    @Override
    public PostResponse updatePost(Long postId, UpdatePostRequest request) {
        return null;
    }

    @Override
    public void deletePost(Long postId) {

    }

    @Override
    public List<PostResponse> getPostsByUser(Long userId) {
        return List.of();
    }

    @Override
    public void increaseHotScore(Long postId, double score) {

    }
}
