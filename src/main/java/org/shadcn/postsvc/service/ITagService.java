package org.shadcn.postsvc.service;

import java.util.List;

import org.shadcn.postsvc.dto.response.TagResponse;

public interface ITagService {
    List<TagResponse> getAllTags();

    TagResponse getTagByName(String name);
}
