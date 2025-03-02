package org.shadcn.postsvc.service;

import org.shadcn.postsvc.dto.response.TagResponse;

import java.util.List;

public interface ITagService {
    List<TagResponse> getAllTags();

    TagResponse getTagByName(String name);
}