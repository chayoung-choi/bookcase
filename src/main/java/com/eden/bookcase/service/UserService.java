package com.eden.bookcase.service;

import com.eden.bookcase.domain.UserEntity;
import com.eden.bookcase.dto.UserDto;

import java.util.List;

public interface UserService {

  /**
   * 사용자 등록
   *
   * @param userDto
   * @return UserDto
   */
  UserDto createUser(UserDto userDto);

  /**
   * 사용자 정보 수정
   *
   * @param userDto
   * @return UserDto
   */
  UserDto updateUser(UserDto userDto);

  /**
   * 사용자 정보 조회
   *
   * @param id
   * @return UserDto
   */
  UserDto getUserById(String id);

  /**
   * 사용자 전체 조회
   *
   * @return List<UserEntity>
   */
  List<UserEntity> getUserByAll();

  /**
   * 사용자 상세 정보 조회
   *
   * @param email
   * @return UserDto
   */
  UserDto getUserDetailsByEmail(String email);
}
