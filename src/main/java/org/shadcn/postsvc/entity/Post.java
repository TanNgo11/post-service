package org.shadcn.postsvc.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    @Column(nullable = false)
    Long userId;

    @Column(nullable = false)
    String title;

    @Column(unique = true, nullable = false)
    String slug;

    @Column(nullable = false, columnDefinition = "TEXT")
    String content;

    Boolean allowComments = true;

    double hotScore = 0.0;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<PostReaction> reactions = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags = new ArrayList<>();


    @PrePersist
    @PreUpdate
    public void generateSlug() {
        if (this.slug == null || hasTitleChanged()) {
            this.slug = toSlug(this.title);
        }
    }

    private boolean hasTitleChanged() {
        return !this.slug.equals(toSlug(this.title));
    }

    private String toSlug(String title) {
        return title.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "")
                .replaceAll("\\s+", "-")
                .trim();
    }
}
