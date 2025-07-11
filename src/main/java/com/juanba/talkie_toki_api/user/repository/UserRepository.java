package com.juanba.talkie_toki_api.user.repository;

import com.juanba.talkie_toki_api.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    UserDetails findByUsername(String username);

    Page<User> findAllByIsActiveTrue(Pageable pageable);

    User findByEmail(String email);
}
