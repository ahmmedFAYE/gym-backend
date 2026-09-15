package com.gym.gym_backend.controller;


import com.gym.gym_backend.dto.AuthResponse;
import com.gym.gym_backend.dto.LoginRequest;
import com.gym.gym_backend.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aut")
@CrossOrigin("http://localhost:4200/login")
public class AuthController {
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        UserDto mockUser = new UserDto();
        mockUser.setUserId("USR-001");
        mockUser.setFirstname("Ahmed");
        mockUser.setLastName("Faye");
        mockUser.setEmail(loginRequest.getEmail());
        mockUser.setPassword(null);
        mockUser.setRole("admin"); // Redirigera vers /admin dans Angular
        mockUser.setAvatar("assets/images/default-avatar.png");
        mockUser.setGymId("GYM-DAKAR-01");
        mockUser.setPermissions(List.of("READ_MEMBERS", "WRITE_MEMBERS", "MANAGE_FINANCE"));

        String mockAccessToken = "mock-jwt-access-token-xyz123";
        String mockRefreshToken = "mock-jwt-refresh-token-abc789";

        AuthResponse authResponse = new AuthResponse(mockUser, mockAccessToken, mockRefreshToken );
        return ResponseEntity.ok(authResponse);
    }
}
