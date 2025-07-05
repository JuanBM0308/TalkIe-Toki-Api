package com.juanba.talkie_toki_api.user.dto.in;

import jakarta.validation.constraints.Email;

public record UpdateUserRequest(
        Long id,

        String userName,

        @Email
        String email,

        String password
) {
}
