package com.eden.bookcase.api;

import com.eden.bookcase.dto.UserDto;
import com.eden.bookcase.service.UserService;
import com.eden.bookcase.vo.RequestUser;
import com.eden.bookcase.vo.ResponseUser;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApi {

  private final Environment env;
  private final UserService userService;

  public UserApi(Environment env, UserService userService) {
    this.env = env;
    this.userService = userService;
  }

  @GetMapping("/users/{uid}")
  public ResponseEntity getUser(@PathVariable String uid) {
//    ResponseMember returnValue = new ModelMapper().map(userDto, ResponseMember.class);
//    return ResponseEntity.ok(ResponseMember);
    UserDto userDto = userService.getUserById(uid);
    return ResponseEntity.ok("OK");
  }

  @PostMapping("/users")
  public ResponseEntity createUser(@RequestBody RequestUser user) {

    ResponseUser responseUser = mapper.map()
    return ResponseEntity.status(HttpStatus.CREATED).body(responseUser);
  }

  @PostMapping("/users/{uid}/confirm")
  public ResponseEntity<?> confirm(@PathVariable String uid) {

//    confirmMemberService.confirm(uid);
    return ResponseEntity.ok("OK");
  }
}
