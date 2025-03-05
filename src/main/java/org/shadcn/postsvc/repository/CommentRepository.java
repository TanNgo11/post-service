package org.shadcn.postsvc.repository;

import java.util.List;

import org.shadcn.postsvc.entity.Comment;
import org.shadcn.postsvc.repository.custom.ICustomCommentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository
        extends JpaRepository<Comment, Long>, QuerydslPredicateExecutor<Comment>, ICustomCommentRepository {
    List<Comment> findByPostId(Long postId);
}
