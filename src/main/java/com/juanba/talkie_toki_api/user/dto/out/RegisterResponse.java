package com.juanba.talkie_toki_api.user.dto.out;

import com.juanba.talkie_toki_api.user.entity.User;

import java.time.LocalDateTime;

public record RegisterResponse(
        Long id,
        String username,
        LocalDateTime registerDate,
        boolean isActive
) {
    public RegisterResponse(User userSaved) {
        this (
                userSaved.getId(),
                userSaved.getUsername(),
                userSaved.getRegisterDate(),
                userSaved.isActive()
        );
    }
}
