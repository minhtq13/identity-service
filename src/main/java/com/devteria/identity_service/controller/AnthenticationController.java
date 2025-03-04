package com.devteria.identity_service.controller;

import java.text.ParseException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devteria.identity_service.dto.request.ApiResponse;
import com.devteria.identity_service.dto.request.AuthenticationRequest;
import com.devteria.identity_service.dto.request.IntrospectRequest;
import com.devteria.identity_service.dto.response.AuthenticationResponse;
import com.devteria.identity_service.dto.response.IntrospectResonse;
import com.devteria.identity_service.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AnthenticationController {

  AuthenticationService authenticationService;

  @PostMapping("/token")
  ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {

    var result = authenticationService.authenticate(request);
    return ApiResponse.<AuthenticationResponse>builder()
        .result(result)
        .build();
  }

  @PostMapping("/introspect")
  ApiResponse<IntrospectResonse> authenticate(@RequestBody IntrospectRequest request)
      throws JOSEException, ParseException {

    var result = authenticationService.introspect(request);
    return ApiResponse.<IntrospectResonse>builder()
        .result(result)
        .build();
  }

}
