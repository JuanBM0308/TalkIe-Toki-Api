package com.juanba.talkie_toki_api.user.dto.in;

public record UpdateUserRequest(
        String userName,
        String email,
        String password
) {
}
