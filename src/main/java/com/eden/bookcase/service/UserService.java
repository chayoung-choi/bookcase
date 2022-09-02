package com.eden.bookcase.service;

import com.eden.bookcase.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  UserDto getUserById(String id);
}
