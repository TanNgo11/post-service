package org.shadcn.postsvc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.shadcn.postsvc.dto.request.CreateCommentRequest;
import org.shadcn.postsvc.dto.response.CommentResponse;
import org.shadcn.postsvc.entity.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "post", ignore = true)
    @Mapping(target = "userId")
    Comment toEntity(CreateCommentRequest request);

    @Mapping(target = "author", source = "userId", qualifiedByName = "toAuthorInfo")
    CommentResponse toCommentResponse(Comment comment);
}