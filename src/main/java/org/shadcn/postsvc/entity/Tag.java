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
@Table(name = "tags")
public class Tag extends BaseEntity {

    String name;

    @ManyToMany(mappedBy = "tags")
    List<Post> posts = new ArrayList<>();


    public Tag(String name) {
        this.name = name;
        this.posts = new ArrayList<>();
    }

}
