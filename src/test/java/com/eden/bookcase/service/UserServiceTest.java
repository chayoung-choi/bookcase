package com.eden.bookcase.service;

import com.eden.bookcase.dto.UserDto;
import com.eden.bookcase.repository.UserRepository;
import com.eden.bookcase.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("User-Service")
class UserServiceTest {

  static UserDto userDto;
  //  @Mock
  @Autowired
  private UserRepository userRepository;

  private ModelMapper mapper;

  //  @InjectMocks
  private UserService userService;

  @BeforeAll
  static void beforeAll() {
    userDto = new UserDto();
    userDto.setEmail("test@gmail.com");
    userDto.setName("test");
    userDto.setPwd("test1234");
  }

  @BeforeEach
  void setUp() {
    this.mapper = new ModelMapper();
    this.userService = new UserServiceImpl(mapper, userRepository);
  }

  @Test
  @DisplayName("사용자 생성")
  void createUser() {
    userDto = userService.createUser(userDto);
    assertThat(!userDto.getId().isEmpty());
  }

  @Test
  @DisplayName("사용자 정보 조회")
  void getUserById() {
    UserDto responseUser = userService.getUserById(userDto.getId());
    assertThat(responseUser.getEmail()).isEqualTo(userDto.getEmail());
  }


}
