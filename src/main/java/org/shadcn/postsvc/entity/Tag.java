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
@Table(name = "tags")
public class Tag extends BaseEntity {
    String name;

    @ManyToMany(mappedBy = "tags")
    List<Post> posts = new ArrayList<>();

    public Tag(String name) {
        this.name = name;
    }
}
