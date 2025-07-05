package com.juanba.talkie_toki_api.comment.service;

import com.juanba.talkie_toki_api.comment.dto.in.CreateCommentRequest;
import com.juanba.talkie_toki_api.comment.dto.out.GetCommentResponse;
import com.juanba.talkie_toki_api.comment.entity.Comment;
import com.juanba.talkie_toki_api.comment.repository.CommentRepository;
import com.juanba.talkie_toki_api.exceptions.NotFoundException;
import com.juanba.talkie_toki_api.user.entity.User;
import com.juanba.talkie_toki_api.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Override
    public Comment createComment(CreateCommentRequest commentRequest) {
        final User user = userRepository.findByEmail(commentRequest.email());

        final Comment comment = Comment.builder()
                .title(commentRequest.title())
                .message(commentRequest.message())
                .user(user)
                .date(LocalDateTime.now())
                .communityTopic(commentRequest.communityTopic())
                .build();

        commentRepository.save(comment);

        return comment;
    }

    @Override
    public Comment getComment(Long id) {
        return commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));
    }

    @Override
    public Page<GetCommentResponse> listComments(Pageable pageable) {
        return commentRepository.findAll(pageable)
                .map(GetCommentResponse::new);
    }
}
