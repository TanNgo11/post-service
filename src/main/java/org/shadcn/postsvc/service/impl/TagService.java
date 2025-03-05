package org.shadcn.postsvc.service.impl;

import java.util.List;

import org.shadcn.postsvc.dto.response.TagResponse;
import org.shadcn.postsvc.repository.TagRepository;
import org.shadcn.postsvc.service.ITagService;
import org.springframework.stereotype.Service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class TagService implements ITagService {
    TagRepository tagRepository;

    @Override
    public List<TagResponse> getAllTags() {
        return null;
    }

    @Override
    public TagResponse getTagByName(String name) {
        return null;
    }
}
