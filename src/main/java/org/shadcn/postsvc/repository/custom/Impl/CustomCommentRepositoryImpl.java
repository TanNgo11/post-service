package org.shadcn.postsvc.repository.custom.Impl;

import java.util.List;

import org.shadcn.postsvc.entity.Comment;
import org.shadcn.postsvc.entity.QComment;
import org.shadcn.postsvc.mapper.CommentMapper;
import org.shadcn.postsvc.repository.custom.ICustomCommentRepository;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CustomCommentRepositoryImpl implements ICustomCommentRepository {
    private final JPAQueryFactory queryFactory;
    private final CommentMapper commentMapper;

    @Override
    public List<Comment> findByPostIdAndParentId(Long postId, Long parentId) {
        QComment comment = QComment.comment;

        return queryFactory
                .selectFrom(comment)
                .leftJoin(comment.post)
                .fetchJoin()
                .leftJoin(comment.parent)
                .fetchJoin()
                .leftJoin(comment.replies)
                .fetchJoin()
                .where(
                        comment.post.id.eq(postId),
                        parentId == null ? comment.parent.isNull() : comment.parent.id.eq(parentId),
                        comment.deleted.eq(false))
                .fetch();
    }
}
