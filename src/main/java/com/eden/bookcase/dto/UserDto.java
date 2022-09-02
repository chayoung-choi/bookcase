package com.eden.bookcase.dto;

import com.eden.bookcase.constants.UserStatus;
import lombok.Data;

@Data
public class UserDto {
  private String id;
  private String name;
  private String email;
  private String pwd;
  private UserStatus status;
}
