package org.shadcn.postsvc.dto.request;

import jakarta.validation.constraints.NotBlank;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReactToPostRequest {
    @NotBlank
    String reaction;
}
