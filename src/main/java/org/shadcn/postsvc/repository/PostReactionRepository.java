package org.shadcn.postsvc.repository;

import java.util.List;

import org.shadcn.postsvc.entity.PostReaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostReactionRepository extends JpaRepository<PostReaction, Long> {
    List<PostReaction> findByPostId(Long postId);

    List<PostReaction> findByUserId(Long userId);
}
