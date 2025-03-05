package org.shadcn.postsvc.repository.custom;

import java.util.List;

import org.shadcn.postsvc.entity.Comment;

public interface ICustomCommentRepository {

    List<Comment> findByPostIdAndParentId(Long postId, Long parentId);
}
