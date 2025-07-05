package com.juanba.talkie_toki_api.comment.service;

import com.juanba.talkie_toki_api.comment.dto.in.CreateCommentRequest;
import com.juanba.talkie_toki_api.comment.dto.out.GetCommentResponse;
import com.juanba.talkie_toki_api.comment.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Comment createComment(CreateCommentRequest commentRequest);

    Comment getComment(Long id);

    Page<GetCommentResponse> listComments(Pageable pageable);
}
