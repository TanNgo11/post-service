package org.shadcn.postsvc.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreatePostRequest {
    @NotBlank
    String title;

    @NotBlank
    String content;

    List<String> tags;

    Boolean allowComments;
}
