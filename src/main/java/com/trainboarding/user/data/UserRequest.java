package com.trainboarding.user.data;

public record UserRequest(String firstName, String lastName, String email) {

    public UserRequest(){
        this(null, null, null);
    }
}