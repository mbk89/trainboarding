package com.trainboarding.user.api;

import com.trainboarding.user.data.UserRequest;
import com.trainboarding.user.dto.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class UserAPITest {

    @Autowired
    UserAPI userAPI;

    @Test
    void testCreateWithNullData() {

        ResponseEntity<UserInfo> response = userAPI.create(new UserRequest());

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), response.getStatusCode().value());
        assertNull(response.getBody());

    }

    @Test
    void testCreateWithValidData() {

        ResponseEntity<UserInfo> response = userAPI.create(
                new UserRequest("Foo", "Bar", "foo@bar.com"));

        assertEquals(HttpStatus.CREATED.value(), response.getStatusCode().value());
        assertNotNull(response.getBody());

        UserInfo userInfo = response.getBody();

        ResponseEntity<UserInfo> getResponse = userAPI.get(String.valueOf(userInfo.key()));

        assertEquals(HttpStatus.OK.value(), getResponse.getStatusCode().value());
        assertNotNull(getResponse.getBody());

    }
}