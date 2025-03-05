package org.shadcn.postsvc.dto.response;

import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PostDetailResponse extends BaseDTOResponse {
    String title;
    String slug;
    String content;
    String userId;
    String fullName;
    List<TagResponse> tags;
    Boolean allowComments;
    PostStarts starts;
    List<CommentResponse> comments;
}
