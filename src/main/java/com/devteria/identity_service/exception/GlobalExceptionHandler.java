package com.devteria.identity_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devteria.identity_service.dto.request.ApiResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<ApiResponse> handleRuntimeException(Exception e) {
    ApiResponse<String> apiResponse = new ApiResponse<>();
    apiResponse.setCode(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode());
    apiResponse.setMessage(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage());
    return ResponseEntity.badRequest().body(apiResponse);
  }

  @ExceptionHandler(value = AppException.class)
  public ResponseEntity<ApiResponse> handleAppException(AppException e) {

    ErrorCode errorCode = e.getErrorCode();
    ApiResponse apiResponse = new ApiResponse();

    apiResponse.setCode(errorCode.getCode());
    apiResponse.setMessage(errorCode.getMessage());
    return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
  }

  @ExceptionHandler(value = AccessDeniedException.class)
  public ResponseEntity<ApiResponse> handleAccessDeniedException(AccessDeniedException e) {

    return ResponseEntity.status(ErrorCode.UNAUTHORIZED.getStatusCode()).body(ApiResponse.builder()
        .code(ErrorCode.UNAUTHORIZED.getCode())
        .message(ErrorCode.UNAUTHORIZED.getMessage())
        .build());
  }

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

    String enumKey = e.getFieldError().getDefaultMessage();

    ErrorCode errorCode = ErrorCode.INVALID_KEY;

    try {
      errorCode = ErrorCode.valueOf(enumKey);
    } catch (IllegalArgumentException exception) {

    }

    ApiResponse apiResponse = new ApiResponse();

    apiResponse.setCode(errorCode.getCode());
    apiResponse.setMessage(errorCode.getMessage());

    return ResponseEntity.badRequest().body(apiResponse);
  }
}
