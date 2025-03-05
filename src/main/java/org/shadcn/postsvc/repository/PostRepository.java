package org.shadcn.postsvc.repository;

import jakarta.transaction.Transactional;

import org.shadcn.postsvc.entity.Post;
import org.shadcn.postsvc.entity.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Page<Post> findAllByUserId(Long userId, Pageable pageable);

    @Modifying
    @Transactional
    @Query("UPDATE Post p SET p.hotScore = p.hotScore + :score WHERE p.id = :postId")
    void increaseHotScore(Long postId, double score);


    @Query("SELECT p FROM Post p JOIN p.tags t WHERE t.name IN :tags")
    Page<Post> findByTags(Set<String> tags, Pageable pageable);
}
