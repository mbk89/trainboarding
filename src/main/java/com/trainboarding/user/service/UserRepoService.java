package com.trainboarding.user.service;

import com.trainboarding.user.dao.User;
import com.trainboarding.user.dto.UserInfo;

public interface UserRepoService {

    UserInfo save(User user);

    UserInfo get(Long key);
}