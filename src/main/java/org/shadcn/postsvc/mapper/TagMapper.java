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
public interface TagMapper {

    @Named("mapTags")
    static List<Tag> mapTags(List<String> tagNames) {
        return tagNames == null ? List.of() :
                tagNames.stream().map(Tag::new).toList();
    }

    @Named("mapTagsToStrings")
    static List<String> mapTagsToStrings(List<Tag> tags) {
        return tags == null ? List.of() :
                tags.stream().map(Tag::getName).toList();
    }
}