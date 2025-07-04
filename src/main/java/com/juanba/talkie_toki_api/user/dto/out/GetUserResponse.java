package com.juanba.talkie_toki_api.user.dto.out;

import com.juanba.talkie_toki_api.user.entity.User;

import java.time.LocalDateTime;

public record GetUserResponse(
        Long id,
        String username,
        String firstName,
        String lastName,
        String email,
        LocalDateTime registerDate,
        boolean isActive
) {
    public GetUserResponse(User recoveredUser) {
        this (
                recoveredUser.getId(),
                recoveredUser.getUsername(),
                recoveredUser.getFirstName(),
                recoveredUser.getLastName(),
                recoveredUser.getEmail(),
                recoveredUser.getRegisterDate(),
                recoveredUser.isActive()
        );
    }
}
