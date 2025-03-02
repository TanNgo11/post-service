package org.shadcn.postsvc.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentResponse {

    Long id;

    String content;

    AuthorInfo author;

    Long postId;

    Long parentId;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    List<CommentResponse> replies;

    double hotScore;
}
