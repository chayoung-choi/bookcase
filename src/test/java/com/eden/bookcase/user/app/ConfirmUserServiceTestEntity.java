package com.eden.bookcase.user.app;

import com.eden.bookcase.domain.UserEntity;
import com.eden.bookcase.constants.UserStatus;
import com.eden.bookcase.exception.MemberAlreadyActivatedException;
import com.eden.bookcase.exception.MemberNotFoundException;
import com.eden.bookcase.repository.UserRepository;
import com.eden.bookcase.repository.MemoryUserRepository;
import com.eden.bookcase.service.ConfirmMemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfirmUserServiceTestEntity {
  public static final String ID = "id";
  private UserRepository userRepository = new MemoryUserRepository();
  private ConfirmMemberService confirmMemberService = new ConfirmMemberService(userRepository);

  @Test
  @DisplayName("회원이 없으면 에러가 발생한")
  void noMember() {
    Assertions.assertThatCode(() -> {
      confirmMemberService.confirm(ID);
    }).isInstanceOf(MemberNotFoundException.class);
  }

  @Test
  void memberAlreadyActivated() {
    userRepository.save(new UserEntity(ID, UserStatus.ACTIVE));

    Assertions.assertThatCode(() -> {
      confirmMemberService.confirm(ID);
    }).isInstanceOf(MemberAlreadyActivatedException.class);
  }

  @Test
  void confirm() {
    // arrange (given)
    userRepository.save(new UserEntity(ID, UserStatus.WAITING));

    confirmMemberService.confirm(ID);

    // assert  (then)
    UserEntity m = userRepository.findById(ID);
    assertThat(m.getStatus()).isEqualTo(UserStatus.ACTIVE);
  }
}
