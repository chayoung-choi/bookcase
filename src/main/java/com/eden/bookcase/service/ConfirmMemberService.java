package com.eden.bookcase.service;

import com.eden.bookcase.domain.UserEntity;
import com.eden.bookcase.exception.MemberNotFoundException;
import com.eden.bookcase.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ConfirmMemberService {
  private final UserRepository userRepository;

  public ConfirmMemberService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public void confirm(String id) {
    UserEntity userEntity = userRepository.findById(id);
    if (userEntity == null) {
      throw new MemberNotFoundException();
    }
//    userEntity.confirm();
  }

}
