package org.shadcn.postsvc.repository;

import org.shadcn.postsvc.entity.PostReaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostReactionRepository extends JpaRepository<PostReaction, Long> {
    List<PostReaction> findByPostId(Long postId);
    List<PostReaction> findByUserId(Long userId);
}
