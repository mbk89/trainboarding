package com.trainboarding.user.api;

import com.trainboarding.user.data.UserRequest;
import com.trainboarding.user.dto.UserInfo;
import com.trainboarding.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/users")
public class UserAPI {

    private final UserService userService;

    @Autowired
    public UserAPI (UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserInfo> create(@RequestBody UserRequest userRequest) {

        UserInfo userInfo = userService.createUser(userRequest);

        if(userInfo == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(userInfo, HttpStatus.CREATED);
        }
    }

    @GetMapping(value = "/{key}")
    public ResponseEntity<UserInfo> get(@PathVariable("key") String key) {
        return new ResponseEntity<>(userService.getUser(key), HttpStatus.OK);
    }
}