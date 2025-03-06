package org.shadcn.postsvc.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.shadcn.postsvc.dto.response.PostResponse;
import org.shadcn.postsvc.dto.response.TagResponse;
import org.shadcn.postsvc.entity.Post;
import org.shadcn.postsvc.entity.Tag;

@Mapper(componentModel = "spring")
public interface TagMapper {
    @Named("mapStringsToTags")
    default Set<Tag> mapStringsToTags(Set<String> tagNames) {
        if (tagNames == null) {
            return Set.of();
        }
        return tagNames.stream().map(Tag::new).collect(Collectors.toSet());
    }

    TagResponse toTagResponse(Tag tag);
}
