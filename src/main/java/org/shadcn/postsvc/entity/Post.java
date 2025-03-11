package org.shadcn.postsvc.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.shadcn.postsvc.enums.Status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    Long userId;

    String fullName;

    String title;

    String slug;

    @Column(columnDefinition = "LONGTEXT")
    String content;

    Boolean allowComments = true;

    double hotScore = 0.0;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true)
    List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<PostReaction> reactions = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "post_tags",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = new HashSet<>();

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

    @Enumerated(EnumType.STRING)
    Status status;

    String thumbnailUrl;
}
