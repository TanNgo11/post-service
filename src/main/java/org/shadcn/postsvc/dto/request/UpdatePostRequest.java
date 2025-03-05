package org.shadcn.postsvc.dto.request;

import java.util.Set;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdatePostRequest {
    String title;
    String content;
    Set<TagRequest> tags;
    Boolean allowComments;
}
