package org.shadcn.postsvc.service.impl;

import org.shadcn.postsvc.dto.response.PageResponse;
import org.shadcn.postsvc.dto.response.TagResponse;
import org.shadcn.postsvc.entity.Tag;
import org.shadcn.postsvc.mapper.TagMapper;
import org.shadcn.postsvc.repository.TagRepository;
import org.shadcn.postsvc.service.ITagService;
import org.shadcn.postsvc.util.ConvertToPaginationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    TagMapper tagMapper;

    @Override
    public PageResponse<TagResponse> getAllTags(int current, int pageSize) {
        Pageable pageable = PageRequest.of(current - 1, pageSize);
        Page<Tag> tags = tagRepository.findAll(pageable);

        return ConvertToPaginationResponse.toPageResponse(tags, tagMapper::toTagResponse, current);
    }

    @Override
    public TagResponse getTagByName(String name) {
        return null;
    }
}
