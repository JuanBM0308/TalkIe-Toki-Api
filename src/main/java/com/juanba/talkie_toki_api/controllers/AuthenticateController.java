package com.juanba.talkie_toki_api.controllers;

import com.juanba.talkie_toki_api.user.dto.in.AuthenticationRequest;
import com.juanba.talkie_toki_api.user.dto.out.AuthenticationResponse;
import com.juanba.talkie_toki_api.user.service.AuthenticationServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/authenticate")
public class AuthenticateController {

    private final AuthenticationServiceImpl authenticationService;

    public AuthenticateController(AuthenticationServiceImpl authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody @Valid AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok(authenticationService.setAuthentication(authenticationRequest));
    }
}
