package com.eden.bookcase.service;

import com.eden.bookcase.dto.UserDto;

public interface UserService {
  UserDto getUserById(String id);

  /**
   * 회원 신규 등록
   *
   * @param userDto
   * @return
   */
  UserDto createUser(UserDto userDto);
}
