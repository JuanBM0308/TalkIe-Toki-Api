package com.juanba.talkie_toki_api.comment.dto.in;

import com.juanba.talkie_toki_api.util.CommunityTopic;
import jakarta.validation.constraints.NotNull;

public record CreateCommentRequest(
        @NotNull
        String title,

        @NotNull
        String message,

        @NotNull
        String email,

        @NotNull
        CommunityTopic communityTopic
) {
}
