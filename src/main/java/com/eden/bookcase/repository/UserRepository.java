package com.eden.bookcase.repository;

import com.eden.bookcase.domain.UserEntity;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<UserEntity, String> {
  UserEntity findById(String id);

  UserEntity findByEmail(String username);

  UserEntity save(UserEntity id);
}
