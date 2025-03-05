package org.shadcn.postsvc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "post_reactions")
public class PostReaction extends BaseEntity {

    String author;

    String reaction;

    Long userId;

    Integer star;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    Post post;
}
