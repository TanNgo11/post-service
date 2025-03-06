package org.shadcn.postsvc.controller;

import static org.shadcn.postsvc.constant.PathConstant.API_V1_POSTS;
import static org.shadcn.postsvc.constant.PathConstant.API_V1_TAGS;

import org.shadcn.postsvc.dto.response.ApiResponse;
import org.shadcn.postsvc.dto.response.PageResponse;
import org.shadcn.postsvc.dto.response.TagResponse;
import org.shadcn.postsvc.service.ITagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(API_V1_TAGS)
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TagController {
    ITagService tagService;

    @GetMapping()
    public ApiResponse<PageResponse<TagResponse>> getAllTags(
            @RequestParam(defaultValue = "1", required = false) Integer current,
            @RequestParam(defaultValue = "10", required = false) Integer pageSize) {
        return ApiResponse.success(tagService.getAllTags(current, pageSize));
    }

}
