package com.eden.bookcase.member.api;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface MemberRepository extends CrudRepository<Member, String> {
  Optional<Member> findById(String id);

  Member save(Member id);
}
