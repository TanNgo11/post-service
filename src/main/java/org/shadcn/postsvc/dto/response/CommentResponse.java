package org.shadcn.postsvc.dto.response;

import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentResponse extends BaseDTOResponse {

    String content;

    Long userId;

    String fullName;

    Long postId;

    Long parentId;

    List<CommentResponse> replies;
}
