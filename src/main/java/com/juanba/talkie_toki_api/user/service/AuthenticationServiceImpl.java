package com.juanba.talkie_toki_api.user.service;

import com.juanba.talkie_toki_api.user.dto.in.AuthenticationRequest;
import com.juanba.talkie_toki_api.user.dto.out.AuthenticationResponse;
import com.juanba.talkie_toki_api.user.entity.User;
import com.juanba.talkie_toki_api.util.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse setAuthentication(AuthenticationRequest authenticationRequest) {
        var authToken = new UsernamePasswordAuthenticationToken(authenticationRequest.username(), authenticationRequest.password());
        var authentication = authenticationManager.authenticate(authToken);

        var jwt = jwtService.generateToken((User) authentication.getPrincipal());

        return new AuthenticationResponse(jwt);
    }
}
