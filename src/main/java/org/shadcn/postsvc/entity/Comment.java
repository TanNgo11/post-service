package org.shadcn.postsvc.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name = "comments")
public class Comment extends BaseEntity {

    @Column(nullable = false)
    Long userId;

    String content;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    Post post;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    Comment parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    List<Comment> replies = new ArrayList<>();

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL)
    List<CommentReaction> reactions = new ArrayList<>();

    boolean deleted = false;
}
