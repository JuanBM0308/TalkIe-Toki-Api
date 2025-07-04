package com.juanba.talkie_toki_api.controllers;

import com.juanba.talkie_toki_api.user.dto.in.RegisterUserRequest;
import com.juanba.talkie_toki_api.user.dto.out.GetUserResponse;
import com.juanba.talkie_toki_api.user.dto.out.RegisterResponse;
import com.juanba.talkie_toki_api.user.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<RegisterResponse> registerUser(@RequestBody @Valid RegisterUserRequest registerUserRequest, UriComponentsBuilder uriComponentsBuilder) {
        final var userSaved = userService.registerUser(registerUserRequest);
        var uri = uriComponentsBuilder.path("/users/{id}").buildAndExpand(userSaved.getId()).toUri();
        return ResponseEntity.created(uri).body(new RegisterResponse(userSaved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponse> getUser(@PathVariable Long id) {
        final var recoveredUser = userService.getUser(id);
        return ResponseEntity.ok(new GetUserResponse(recoveredUser));
    }

    @GetMapping
    public ResponseEntity<Page<GetUserResponse>> listUsers(@PageableDefault(sort = {"username"}) Pageable pageable) {
        return ResponseEntity.ok(userService.listUsers(pageable));
    }
}
