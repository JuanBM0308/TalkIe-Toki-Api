package com.juanba.talkie_toki_api.comment.dto.out;

import com.juanba.talkie_toki_api.comment.entity.Comment;

import java.time.LocalDateTime;

public record GetCommentResponse(
        Long id,
        String community_topic,
        String title,
        String message,
        UserCommentResponse publisher,
        LocalDateTime publicationDate
) {
    public GetCommentResponse(Comment commentSaved) {
        this(
                commentSaved.getId(),
                commentSaved.getCommunityTopic().name(),
                commentSaved.getTitle(),
                commentSaved.getMessage(),
                new UserCommentResponse(commentSaved.getUser()),
                commentSaved.getDate()
        );
    }
}
