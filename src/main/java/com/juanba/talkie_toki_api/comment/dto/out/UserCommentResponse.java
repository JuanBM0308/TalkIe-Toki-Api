package com.juanba.talkie_toki_api.comment.dto.out;

import com.juanba.talkie_toki_api.user.entity.User;

import java.time.LocalDateTime;

public record UserCommentResponse(
        Long id,
        String username,
        LocalDateTime registerDate,
        boolean isActive
) {
    public UserCommentResponse(User user) {
        this(
                user.getId(),
                user.getUsername(),
                user.getRegisterDate(),
                user.isActive()
        );
    }
}
