package com.quangta.service;

import com.nimbusds.jose.JOSEException;
import com.quangta.dto.request.AuthenticationRequest;
import com.quangta.dto.request.IntrospectRequest;
import com.quangta.dto.response.AuthenticationResponse;
import com.quangta.dto.response.IntrospectResponse;
import com.quangta.entity.User;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);

    String generateToken(User user);

    String buildScope(User user);

    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
}
