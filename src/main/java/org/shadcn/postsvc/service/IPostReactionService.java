package org.shadcn.postsvc.service;

import java.util.List;

import org.shadcn.postsvc.dto.request.CreatePostReactionRequest;
import org.shadcn.postsvc.dto.response.PostReactionResponse;

public interface IPostReactionService {
    PostReactionResponse reactToPost(CreatePostReactionRequest request);

    void removeReaction(Long reactionId);

    //    List<PostReactionResponse> getReactionsByPostId(Long postId)

    List<PostReactionResponse> getReactionsByUserId(Long userId);
}
