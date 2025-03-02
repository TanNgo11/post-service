package org.shadcn.postsvc.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponse {
    Long id;
    String title;
    String slug;
    String content;
    AuthorInfo author;
    List<String> tags;
    Boolean allowComments;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    double hotScore;
}
