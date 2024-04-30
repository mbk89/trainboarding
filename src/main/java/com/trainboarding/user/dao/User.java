package com.trainboarding.user.dao;

import com.trainboarding.common.dao.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @EqualsAndHashCode(callSuper = true)
@Table(name = "user")
@Entity(name = "USER")
public class User extends BaseEntity {

    @Column(name = "key", unique = true, updatable = false, nullable = false)
    Long key;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @Column(name = "email")
    String email;
}