package com.eden.bookcase.member.repository;

import com.eden.bookcase.member.domain.Member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

  private Map<String, Member> members = new HashMap<>();

  @Override
  public Member save(Member member) {
    members.put(member.getUid(), member);
    return member;
  }

  @Override
  public Member findById(String id) {
    return members.get(id);
  }
}
