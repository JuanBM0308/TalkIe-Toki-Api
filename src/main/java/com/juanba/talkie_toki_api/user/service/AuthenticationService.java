package com.juanba.talkie_toki_api.user.service;

import com.juanba.talkie_toki_api.user.dto.in.AuthenticationRequest;
import com.juanba.talkie_toki_api.user.dto.out.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse setAuthentication(AuthenticationRequest authenticationRequest);
}
