package com.trainboarding.user.service;

import com.trainboarding.user.data.UserRequest;
import com.trainboarding.user.dto.UserInfo;

public interface UserService {

    UserInfo createUser(UserRequest userRequest);

    UserInfo getUser(String key);
}