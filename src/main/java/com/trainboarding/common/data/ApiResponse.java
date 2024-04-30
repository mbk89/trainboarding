package com.trainboarding.common.data;

public record ApiResponse (boolean success, Object data, String error, String message){
}