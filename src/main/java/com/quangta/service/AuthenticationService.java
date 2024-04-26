package com.quangta.service;

import com.nimbusds.jose.JOSEException;
import com.quangta.dto.request.AuthenticationRequest;
import com.quangta.dto.request.IntrospectRequest;
import com.quangta.dto.response.AuthenticationResponse;
import com.quangta.dto.response.IntrospectResponse;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);

    String generateToken(String username);

    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
}
