package com.quangta.service;

import com.quangta.dto.request.AuthenticationRequest;

public interface AuthenticationService {
    boolean authenticate(AuthenticationRequest request);
}
