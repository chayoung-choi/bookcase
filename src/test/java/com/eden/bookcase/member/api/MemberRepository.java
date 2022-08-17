package com.eden.bookcase.member.api;

import org.springframework.data.repository.Repository;

public interface MemberRepository extends Repository<Member, String> {
  Member findById(String id);

  Member save(Member id);
}
