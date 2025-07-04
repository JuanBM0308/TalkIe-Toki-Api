package com.juanba.talkie_toki_api.user.dto.in;

import jakarta.validation.constraints.NotNull;

public record AuthenticationRequest(
        @NotNull
        String username,

        @NotNull
        String password
) {
}
