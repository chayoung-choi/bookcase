package com.eden.bookcase.service;

import com.eden.bookcase.dto.UserDto;
import com.eden.bookcase.repository.UserRepository;
import com.eden.bookcase.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserServiceTest {

  UserDto userDto;

  private ModelMapper mapper;
  private UserRepository userRepository;
  private UserService userService = new UserServiceImpl(mapper, userRepository);

  UserServiceTest(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Test
  void createUser() {
    userDto = new UserDto();
    userDto.setEmail("test@gmail.com");
    userDto.setName("test");
    userDto.setPwd("test1234");
    userService.createUser(userDto);

    assertThat(!userDto.getId().isEmpty());
  }

  @Test
  void getUserById() {
  }


}