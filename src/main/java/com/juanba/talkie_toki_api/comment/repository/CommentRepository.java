package com.juanba.talkie_toki_api.comment.repository;

import com.juanba.talkie_toki_api.comment.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findAllByIsActiveTrue(Pageable pageable);
}
