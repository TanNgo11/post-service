package org.shadcn.postsvc.repository;

import java.util.Optional;
import java.util.Set;

import org.shadcn.postsvc.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByName(String name);

    Set<Tag> findByNameIn(Set<String> names);
}
