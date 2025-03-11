package org.shadcn.postsvc.service;

import org.shadcn.postsvc.dto.response.PageResponse;
import org.shadcn.postsvc.dto.response.TagResponse;

public interface ITagService {
    PageResponse<TagResponse> getAllTags(int current, int pageSize);

    TagResponse getTagByName(String name);
}
