package com.onlinelearningplatform.model;

import com.onlinelearningplatform.entity.UserEntity;

public class LoginResponseModel {

    public final static String AUTHENTICATION_SUCCESS = "Authentication Success";
    public final static String EMAIL_PASSWORD_INVALID = "Email or password is invalid";

    public final static String USER_NOT_ACTIVATED = "User is account is not activated";
    private String token;
    private UserEntity user;

    private String responseMessage;
    private boolean responseStatus;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public boolean isResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(boolean responseStatus) {
        this.responseStatus = responseStatus;
    }
}
