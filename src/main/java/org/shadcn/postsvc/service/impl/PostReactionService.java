package org.shadcn.postsvc.service.impl;

import java.util.List;

import org.shadcn.postsvc.dto.request.CreatePostReactionRequest;
import org.shadcn.postsvc.dto.response.PostReactionResponse;
import org.shadcn.postsvc.service.IPostReactionService;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PostReactionService implements IPostReactionService {
    @Override
    public PostReactionResponse reactToPost(CreatePostReactionRequest request) {
        return null;
    }

    @Override
    public void removeReaction(Long reactionId) {}

    @Override
    public List<PostReactionResponse> getReactionsByUserId(Long userId) {
        return List.of();
    }
}
