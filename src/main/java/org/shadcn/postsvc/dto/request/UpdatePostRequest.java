package org.shadcn.postsvc.dto.request;

import java.util.Set;

import jakarta.validation.constraints.NotBlank;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdatePostRequest {
    @NotBlank
    String title;

    Long userId;

    String fullName;

    @NotBlank
    String content;

    Set<TagRequest> tags;

    Boolean allowComments;

    Boolean isMobile;

    String thumbnailUrl;
}
