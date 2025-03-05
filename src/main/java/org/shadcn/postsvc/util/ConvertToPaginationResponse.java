package org.shadcn.postsvc.util;

import java.util.function.Function;

import org.shadcn.postsvc.dto.response.PageResponse;
import org.springframework.data.domain.Page;

public class ConvertToPaginationResponse {
    public static <T, R> PageResponse<R> toPageResponse(Page<T> pageData, Function<T, R> mapper, int currentPage) {
        return new PageResponse<>(
                currentPage,
                pageData.getSize(),
                pageData.getTotalPages(),
                pageData.getTotalElements(),
                pageData.getContent().stream().map(mapper).toList());
    }
}
