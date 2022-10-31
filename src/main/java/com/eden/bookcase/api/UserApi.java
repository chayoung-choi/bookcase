package com.eden.bookcase.api;

import com.eden.bookcase.domain.UserEntity;
import com.eden.bookcase.dto.UserDto;
import com.eden.bookcase.service.UserService;
import com.eden.bookcase.vo.RequestUser;
import com.eden.bookcase.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserApi {

  private final Environment env;
  private final ModelMapper mapper;
  private final UserService userService;

  @GetMapping("/users")
  public ResponseEntity<List<ResponseUser>> getUsers() {
    Iterable<UserEntity> userList = userService.getUserByAll();
    List<ResponseUser> result = new ArrayList<>();

    userList.forEach(v ->
            result.add(mapper.map(v, ResponseUser.class))
    );

    return ResponseEntity.status(HttpStatus.OK).body(result);
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<ResponseUser> getUser(@PathVariable String id) {
    UserDto userDto = userService.getUserById(id);
    ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);
    return ResponseEntity.status(HttpStatus.OK).body(responseUser);
  }

  @PostMapping("/users")
  public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser user) {
    UserDto userDto = mapper.map(user, UserDto.class);
    userService.createUser(userDto);

    ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
  }

  @PostMapping("/users/{id}")
  public ResponseEntity<ResponseUser> updateUser(@PathVariable String id,
                                                 @RequestBody RequestUser user) {
    UserDto userDto = mapper.map(user, UserDto.class);
    userDto.setId(id);
    userService.updateUser(userDto);
    ResponseUser responseUser = mapper.map(userDto, ResponseUser.class);
    return ResponseEntity.status(HttpStatus.OK).body(responseUser);
  }

  @PostMapping("/users/{id}/confirm")
  public ResponseEntity<?> confirm(@PathVariable String id) {

//    confirmMemberService.confirm(uid);
    return ResponseEntity.ok("OK");
  }
}
