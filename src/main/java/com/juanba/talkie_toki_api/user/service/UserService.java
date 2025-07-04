package com.juanba.talkie_toki_api.user.service;

import com.juanba.talkie_toki_api.user.dto.in.RegisterUserRequest;
import com.juanba.talkie_toki_api.user.dto.in.UpdateUserRequest;
import com.juanba.talkie_toki_api.user.dto.out.GetUserResponse;
import com.juanba.talkie_toki_api.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User registerUser(RegisterUserRequest registerRequest);
    User getUser(Long id);
    Page<GetUserResponse> listUsers(Pageable pageable);
    void deleteUser(Long id);
    User updateUser(UpdateUserRequest updateRequest);
}
