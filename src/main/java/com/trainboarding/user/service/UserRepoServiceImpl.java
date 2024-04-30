package com.trainboarding.user.service;

import com.trainboarding.user.dao.User;
import com.trainboarding.user.dto.UserInfo;
import com.trainboarding.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRepoServiceImpl implements UserRepoService {

    private final UserRepository userRepository;

    @Autowired
    public UserRepoServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserInfo save(User user){
        return transform(userRepository.save(user));
    }

    public UserInfo get(Long key) {
        return transform(userRepository.findByKey(key));
    }

    private UserInfo transform (User user) {
        return new UserInfo(user.getKey(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
}