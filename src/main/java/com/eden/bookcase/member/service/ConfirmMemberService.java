package com.eden.bookcase.member.service;

import com.eden.bookcase.member.domain.Member;
import com.eden.bookcase.member.exception.MemberNotFoundException;
import com.eden.bookcase.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ConfirmMemberService {
  private final MemberRepository memberRepository;

  public ConfirmMemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Transactional
  public void confirm(String id) {
    Member member = memberRepository.findById(id);
    if (member == null) {
      throw new MemberNotFoundException();
    }
    member.confirm();
  }

}
