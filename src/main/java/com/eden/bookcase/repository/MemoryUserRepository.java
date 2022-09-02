package com.eden.bookcase.repository;

import com.eden.bookcase.domain.UserEntity;

import java.util.HashMap;
import java.util.Map;

public class MemoryUserRepository implements UserRepository {

  private Map<String, UserEntity> users = new HashMap<>();

  @Override
  public UserEntity save(UserEntity userEntity) {
    users.put(userEntity.getId(), userEntity);
    return userEntity;
  }

  @Override
  public UserEntity findById(String id) {
    return users.get(id);
  }

  @Override
  public UserEntity findByEmail(String username) {
    return null;
  }
}
