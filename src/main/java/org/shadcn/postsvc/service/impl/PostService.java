package org.shadcn.postsvc.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import org.shadcn.postsvc.dto.request.CreatePostRequest;
import org.shadcn.postsvc.dto.request.TagRequest;
import org.shadcn.postsvc.dto.request.UpdatePostRequest;
import org.shadcn.postsvc.dto.response.PageResponse;
import org.shadcn.postsvc.dto.response.PostDetailResponse;
import org.shadcn.postsvc.dto.response.PostResponse;
import org.shadcn.postsvc.dto.response.UserProfileResponse;
import org.shadcn.postsvc.entity.Post;
import org.shadcn.postsvc.entity.Tag;
import org.shadcn.postsvc.enums.Status;
import org.shadcn.postsvc.exception.AppException;
import org.shadcn.postsvc.exception.ErrorCode;
import org.shadcn.postsvc.mapper.PostMapper;
import org.shadcn.postsvc.repository.PostRepository;
import org.shadcn.postsvc.repository.TagRepository;
import org.shadcn.postsvc.repository.httpClient.IdentityClient;
import org.shadcn.postsvc.service.IPostService;
import org.shadcn.postsvc.util.ConvertToPaginationResponse;
import org.shadcn.postsvc.util.UserUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PostService implements IPostService {
    PostRepository postRepository;
    PostMapper postMapper;
    TagRepository tagRepository;
    IdentityClient identityClient;

    @Override
    public void createPost(CreatePostRequest request) {
        Set<Tag> tags = handleTags(request.getTags());
        Post myPost = postMapper.toPost(request);
        UserProfileResponse author =
                identityClient.getProfileByUserId(request.getUserId()).getResult();
        String fullName = UserUtil.buildFullNameWithBuilder(author);
        myPost.setFullName(fullName);
        myPost.setTags(tags);
        postRepository.save(myPost);
    }

    @Override
    public PostDetailResponse getPostDetailById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new AppException(ErrorCode.POST_NOT_EXISTED));
        return postMapper.toPostDetailResponse(post);
    }

    @Override
    public PageResponse<PostResponse> getAllPosts(int current, int pageSize) {
        Pageable pageable = PageRequest.of(current - 1, pageSize);
        Page<Post> baseCourses = postRepository.findAll(pageable);
        return ConvertToPaginationResponse.toPageResponse(baseCourses, postMapper::toPostResponse, current);
    }

    @Override
    public void updatePost(Long postId, UpdatePostRequest request) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new AppException(ErrorCode.POST_NOT_EXISTED));
        Set<Tag> tags = handleTags(request.getTags());
        postMapper.updatePostFromRequest(request, post);
        post.setTags(tags);
        postRepository.save(post);
    }

    @Override
    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new AppException(ErrorCode.POST_NOT_EXISTED));
        postRepository.delete(post);
    }

    @Override
    public PageResponse<PostResponse> getAllPostsByAuthor(Long authorId, int current, int pageSize) {
        Pageable pageable = PageRequest.of(current - 1, pageSize);
        Page<Post> listPost = postRepository.findAllByUserId(authorId, pageable);
        return ConvertToPaginationResponse.toPageResponse(listPost, postMapper::toPostResponse, current);
    }

    @Override
    @Transactional
    public void increaseHotScore(Long postId, double score) {
        postRepository.increaseHotScore(postId, score);
    }

    @Override
    public void changePostStatus(Long postId, Status status) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new AppException(ErrorCode.POST_NOT_EXISTED));
        post.setStatus(status);
        postRepository.save(post);
    }

    @Override
    public PageResponse<PostResponse> findByTags(Set<String> tag, int current, int pageSize) {
        Pageable pageable = PageRequest.of(current - 1, pageSize);
        Page<Post> postList = postRepository.findByTags(tag,  pageable);
        
        return ConvertToPaginationResponse.toPageResponse(postList, postMapper::toPostResponse, current);
    }

    private Set<Tag> handleTags(Set<TagRequest> tagRequests) {
        Set<String> tagNames = tagRequests.stream().map(TagRequest::getName).collect(Collectors.toSet());
        Set<Tag> existingTags = tagRepository.findByNameIn(tagNames);
        Map<String, Tag> existingTagMap =
                existingTags.stream().collect(Collectors.toMap(Tag::getName, tag -> tag, (tag1, tag2) -> tag1));
        Set<Tag> tags = new HashSet<>();
        for (String tagName : tagNames) {
            Tag tag = existingTagMap.get(tagName);
            if (tag == null) {
                tag = new Tag(tagName);
                tag = tagRepository.save(tag);
            }
            tags.add(tag);
        }
        return tags;
    }
}
