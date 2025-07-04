package com.juanba.talkie_toki_api.user.dto.in;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterUserRequest(

        @NotNull(message = "User name is mandatory")
        @Size(min = 2, max = 20, message = "Name: must be between 2 and 20 characters")
        String userName,

        @NotNull(message = "First name is mandatory")
        @Size(min = 2, max = 20, message = "Surname: must be between 2 and 20 characters")
        String firstName,

        @NotNull(message = "Last name is mandatory")
        String lastName,

        @Email
        String email,

        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!*()]).{8,}$",
                message = "Password: Minimum eight characters, at least one lower and upper case letter, and one special character")
        String password
) {
}
