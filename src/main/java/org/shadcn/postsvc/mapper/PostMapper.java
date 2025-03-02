package org.shadcn.postsvc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.shadcn.postsvc.dto.request.CreatePostRequest;
import org.shadcn.postsvc.dto.response.PostResponse;
import org.shadcn.postsvc.entity.Post;
import org.shadcn.postsvc.entity.Tag;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "hotScore", source = "hotScore")
    @Mapping(target = "tags", source = "tags", qualifiedByName = "mapTags")
    @Mapping(target = "author", source = "userId", qualifiedByName = "toAuthorInfo")
    PostResponse toPostResponse(Post post);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "slug", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "reactions", ignore = true)
    @Mapping(target = "tags", source = "tags", qualifiedByName = "mapTags")
    Post toEntity(CreatePostRequest request);

    @Named("mapTags")
    static List<Tag> mapTags(List<String> tagNames) {
        return tagNames == null ? List.of() :
                tagNames.stream().map(Tag::new).toList();    }

}