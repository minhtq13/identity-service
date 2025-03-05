package com.devteria.identity_service.dto.request;

import java.time.LocalDate;

import com.devteria.identity_service.validator.DobConstraint;

import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
  @Size(min = 4, max = 20, message = "USERNAME_INVALID")
  String username;

  @Size(min = 6, max = 20, message = "PASSWORD_INVALID")
  String password;
  String firstName;
  String lastName;

  @DobConstraint(min = 16, message = "INVALID_DOB")
  LocalDate dob;

}
