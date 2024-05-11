package com.quangta.service;

import java.text.ParseException;

import com.nimbusds.jose.JOSEException;
import com.quangta.dto.request.*;
import com.quangta.dto.response.AuthenticationResponse;
import com.quangta.dto.response.IntrospectResponse;
import com.quangta.entity.User;

public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest request);

    String generateToken(User user);

    AuthenticationResponse refreshToken(RefreshTokenRequest request) throws ParseException, JOSEException;

    String buildScope(User user);

    void logout(LogoutRequest request) throws ParseException, JOSEException;

    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;

    void forgotPassword(ForgotPasswordRequest request);

    void changePassword(String userId, ChangePasswordRequest request);
}
