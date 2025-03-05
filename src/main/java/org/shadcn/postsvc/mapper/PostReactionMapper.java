package org.shadcn.postsvc.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostReactionMapper {

    //        @Mapping(target = "id", ignore = true)
    //        @Mapping(target = "post", ignore = true)
    //        @Mapping(target = "userId", source = "userId")
    //        PostReaction toEntity(CreatePostReactionRequest request);
    //
    ////        @Mapping(target = "author", source = "userId", qualifiedByName = "toAuthorInfo")
    //        PostReactionResponse toReactionResponse(PostReaction reaction);

}
