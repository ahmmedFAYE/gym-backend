package com.gym.gym_backend.dto;

import lombok.Getter;

@Getter
public class AuthResponse {
    private UserDto user;
    private String accessToken;
    private String refreshToken;

    public  AuthResponse(){}

    public AuthResponse(UserDto user, String accessToken, String refreshToken) {
        this.user = user;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
