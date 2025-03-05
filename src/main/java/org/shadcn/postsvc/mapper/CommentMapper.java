package org.shadcn.postsvc.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.shadcn.postsvc.dto.request.CreateCommentRequest;
import org.shadcn.postsvc.dto.response.CommentResponse;
import org.shadcn.postsvc.entity.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentResponse toCommentResponse(CommentResponse commentResponse);

    @Mapping(target = "post", ignore = true)
    @Mapping(target = "parent", ignore = true)
    @Mapping(target = "replies", ignore = true)
    @Mapping(target = "reactions", ignore = true)
    Comment toComment(CreateCommentRequest request);

    @Mapping(source = "content", target = "content")
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "post.id", target = "postId")
    @Mapping(source = "parent.id", target = "parentId")
    @Mapping(source = "replies", target = "replies")
    CommentResponse toCommentResponse(Comment comment);

    List<CommentResponse> toCommentResponseList(List<Comment> comments);
}
