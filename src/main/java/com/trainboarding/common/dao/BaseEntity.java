package com.trainboarding.common.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    String id;

    @Column(name = "date_added", updatable = false, nullable = false)
    LocalDateTime dataAdded;

    @Column(name = "date_modified")
    LocalDateTime dateModified;

    @Column(name = "deleted")
    Boolean deleted;
}