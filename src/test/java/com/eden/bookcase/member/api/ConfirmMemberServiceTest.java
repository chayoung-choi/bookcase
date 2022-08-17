package com.eden.bookcase.member.api;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfirmMemberServiceTest {
  public static final String ID = "id";
  private MemberRepository memberRepository = new MemoryMemberRepository();
  private ConfirmMemberService confirmMemberService = new ConfirmMemberService(memberRepository);

  @Test
  @DisplayName("회원이 없으면 에러가 발생한")
  void noMember() {
    Assertions.assertThatCode(() -> {
      confirmMemberService.confirm(ID);
    }).isInstanceOf(MemberNotFoundException.class);
  }

  @Test
  void memberAlreadyActivated() {
    memberRepository.save(new Member(ID, MemberStatus.ACTIVE));

    Assertions.assertThatCode(() -> {
      confirmMemberService.confirm(ID);
    }).isInstanceOf(MemberAlreadyActivatedException.class);
  }

  @Test
  void confirm() {
    // arrange (given)
    memberRepository.save(new Member(ID, MemberStatus.WAITING));

    confirmMemberService.confirm(ID);

    // assert  (then)
    Member m = memberRepository.findById(ID);
    assertThat(m.getStatus()).isEqualTo(MemberStatus.ACTIVE);
  }
}
