package com.juanba.talkie_toki_api.user.service;

import com.juanba.talkie_toki_api.user.dto.in.RegisterUserRequest;
import com.juanba.talkie_toki_api.user.dto.in.UpdateUserRequest;
import com.juanba.talkie_toki_api.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Override
    public User registerUser(RegisterUserRequest registerRequest) {
        return null;
    }

    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public Page<User> listUsers(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public User updateUser(UpdateUserRequest updateRequest) {
        return null;
    }
}
