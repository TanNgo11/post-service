package org.shadcn.postsvc.dto.response;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.*;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MappedSuperclass
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseDTOResponse implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createddate")
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdDate;

    @Column(name = "modifieddate")
    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modifiedDate;

    @Column(name = "createdBy")
    @CreatedBy
    private String createdBy;

    @Column(name = "modifiedby")
    @LastModifiedBy
    private String modifiedBy;
}
