package com.trainboarding.user.repository;

import com.trainboarding.user.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByKey(Long key);
}