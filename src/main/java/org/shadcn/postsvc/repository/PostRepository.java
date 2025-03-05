package org.shadcn.postsvc.repository;

import jakarta.transaction.Transactional;

import org.shadcn.postsvc.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllByUserId(Long userId, Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE Post p SET p.hotScore = p.hotScore + :score WHERE p.id = :postId")
    void increaseHotScore(Long postId, double score);
}
