package org.shadcn.postsvc.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.shadcn.postsvc.dto.request.CreatePostRequest;
import org.shadcn.postsvc.dto.request.UpdatePostRequest;
import org.shadcn.postsvc.dto.response.PostDetailResponse;
import org.shadcn.postsvc.dto.response.PostResponse;
import org.shadcn.postsvc.dto.response.TagResponse;
import org.shadcn.postsvc.entity.Post;
import org.shadcn.postsvc.entity.Tag;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "tags", source = "tags")
    PostResponse toPostResponse(Post post);

    List<TagResponse> toTagResponseList(List<Tag> tags);

    @Mapping(target = "tags", source = "tags")
    PostDetailResponse toPostDetailResponse(Post post);

    void updatePostFromRequest(UpdatePostRequest request, @MappingTarget Post post);

    Post toPost(CreatePostRequest request);
}
