package org.shadcn.postsvc.dto.response;

import java.time.LocalDateTime;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostReactionResponse {
    Long postId;
    Long userId;
    String reaction;
    LocalDateTime createdAt;
}
