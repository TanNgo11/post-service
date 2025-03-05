package org.shadcn.postsvc.dto.response;

import java.util.Set;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostResponse extends BaseDTOResponse {
    String title;
    String slug;
    String content;
    String userId;
    String fullName;
    Set<TagResponse> tags;
    Boolean allowComments;
    double hotScore;
}
