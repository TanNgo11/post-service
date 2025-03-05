package org.shadcn.postsvc.entity;

import jakarta.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "comment_reactions")
public class CommentReaction extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    Comment comment;

    @Column(nullable = false)
    Long userId;
}
