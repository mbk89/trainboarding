package com.trainboarding.user.service;

import com.trainboarding.user.dao.User;
import com.trainboarding.user.data.UserRequest;
import com.trainboarding.user.dto.UserInfo;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepoService userRepoService;

    @Autowired
    public UserServiceImpl(UserRepoService userRepoService) {
        this.userRepoService = userRepoService;
    }


    @Override
    public UserInfo createUser(UserRequest userRequest) {

        UserInfo userInfo = null;

        if(!validateNull(userRequest)) {
            User user = new User();

            user.setId(UUID.randomUUID().toString());
            user.setKey(Instant.now().toEpochMilli());
            user.setFirstName(userRequest.firstName());
            user.setLastName(userRequest.lastName());
            user.setEmail(userRequest.email());
            user.setDataAdded(LocalDateTime.now());
            user.setDateModified(LocalDateTime.now());
            user.setDeleted(false);

            userInfo = userRepoService.save(user);
        }

        return userInfo;
    }

    @Override
    public UserInfo getUser(String key) {
        return userRepoService.get(Long.parseLong(key));
    }

    private boolean validateNull(UserRequest userRequest) {

        return userRequest == null
                || StringUtils.isEmpty(userRequest.firstName())
                || StringUtils.isEmpty(userRequest.lastName())
                || StringUtils.isEmpty(userRequest.email());
    }
}