package com.quangta.controller;

import java.text.ParseException;

import com.nimbusds.jose.JOSEException;
import com.quangta.dto.request.AuthenticationRequest;
import com.quangta.dto.request.IntrospectRequest;
import com.quangta.dto.request.LogoutRequest;
import com.quangta.dto.request.RefreshTokenRequest;
import com.quangta.dto.response.ApiResponse;
import com.quangta.dto.response.AuthenticationResponse;
import com.quangta.dto.response.IntrospectResponse;
import com.quangta.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/login")
    public ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        var result = authenticationService.authenticate(request);

        return ApiResponse.<AuthenticationResponse>builder().result(result).build();
    }

    @PostMapping("/verify-token")
    public ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);

        return ApiResponse.<IntrospectResponse>builder().result(result).build();
    }

    @PostMapping("/refresh-token")
    public ApiResponse<AuthenticationResponse> refreshToken(@RequestBody RefreshTokenRequest request)
            throws ParseException, JOSEException {
        var result = authenticationService.refreshToken(request);

        return ApiResponse.<AuthenticationResponse>builder().result(result).build();
    }

    @PostMapping("/logout")
    public ApiResponse<Void> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {
        authenticationService.logout(request);

        return ApiResponse.<Void>builder().build();
    }
}
