package com.eden.bookcase.member.repository;

import com.eden.bookcase.member.domain.Member;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends Repository<Member, String> {
  Member findById(String id);

  Member save(Member id);
}
