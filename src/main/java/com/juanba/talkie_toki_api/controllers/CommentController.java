package com.juanba.talkie_toki_api.controllers;

import com.juanba.talkie_toki_api.comment.dto.in.CreateCommentRequest;

import com.juanba.talkie_toki_api.comment.dto.out.GetCommentResponse;
import com.juanba.talkie_toki_api.comment.service.CommentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    
    private final CommentServiceImpl commentService;

    public CommentController(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<GetCommentResponse> createComment(@RequestBody @Valid CreateCommentRequest commentRequest, UriComponentsBuilder uriComponentsBuilder) {
        final var commentSaved = commentService.createComment(commentRequest);
        final var uri = uriComponentsBuilder.path("/comments/{id}").buildAndExpand(commentSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(new GetCommentResponse(commentSaved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCommentResponse> getComment(@PathVariable Long id) {
        final var recoveredComment = commentService.getComment(id);
        return ResponseEntity.ok(new GetCommentResponse(recoveredComment));
    }

    @GetMapping
    public ResponseEntity<Page<GetCommentResponse>> listComments(@PageableDefault(sort = {"date"}) Pageable pageable) {
        return ResponseEntity.ok(commentService.listComments(pageable));
    }
}
