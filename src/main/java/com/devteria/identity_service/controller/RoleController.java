package com.devteria.identity_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devteria.identity_service.dto.request.ApiResponse;
import com.devteria.identity_service.dto.request.RoleRequest;
import com.devteria.identity_service.dto.response.RoleResponse;
import com.devteria.identity_service.service.RoleService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {

  RoleService roleService;

  @PostMapping
  public ApiResponse<RoleResponse> create(@RequestBody RoleRequest request) {
    return ApiResponse.<RoleResponse>builder()
        .result(roleService.create(request))
        .build();
  }

  @GetMapping
  public ApiResponse<List<RoleResponse>> getAll() {
    return ApiResponse.<List<RoleResponse>>builder()
        .result(roleService.getAll())
        .build();
  }

  @DeleteMapping("/{role}")
  public ApiResponse<Void> delete(@PathVariable String role) {
    roleService.delete(role);
    return ApiResponse.<Void>builder().build();
  }
}
