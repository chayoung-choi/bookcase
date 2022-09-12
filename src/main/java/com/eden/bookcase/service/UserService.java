package com.eden.bookcase.service;

import com.eden.bookcase.domain.UserEntity;
import com.eden.bookcase.dto.UserDto;

public interface UserService {
  /**
   * 사용자 정보 조회
   *
   * @param id
   * @return
   */
  UserDto getUserById(String id);

  /**
   * 사용자 등록
   *
   * @param userDto
   * @return
   */
  UserDto createUser(UserDto userDto);

  /**
   * 사용자 전체 조회
   *
   * @return
   */
  Iterable<UserEntity> getUserByAll();

  /**
   * 사용자 상세 정보 조회
   *
   * @param email
   * @return
   */
  UserDto getUserDetailsByEmail(String email);
}
