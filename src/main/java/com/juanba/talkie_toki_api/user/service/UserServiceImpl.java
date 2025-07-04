package com.juanba.talkie_toki_api.user.service;

import com.juanba.talkie_toki_api.user.dto.in.RegisterUserRequest;
import com.juanba.talkie_toki_api.user.dto.in.UpdateUserRequest;
import com.juanba.talkie_toki_api.user.dto.out.GetUserResponse;
import com.juanba.talkie_toki_api.user.entity.User;
import com.juanba.talkie_toki_api.user.repository.UserRepository;
import com.juanba.talkie_toki_api.util.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public User registerUser(RegisterUserRequest registerRequest) {
        final User user = User.builder()
                .username(registerRequest.userName())
                .firstName(registerRequest.firstName())
                .lastName(registerRequest.lastName())
                .email(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password()))
                .role(Role.NORMAL_USER)
                .registerDate(LocalDateTime.now())
                .isActive(true)
                .build();

        userRepository.save(user);

        return user;
    }

    @Override
    public User getUser(Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found in the database"));

        return user;
    }

    @Override
    public Page<GetUserResponse> listUsers(Pageable pageable) {
        return userRepository.findAllByIsActiveTrue(pageable)
                .map(GetUserResponse::new);
    }


    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public User updateUser(UpdateUserRequest updateRequest) {
        return null;
    }
}
