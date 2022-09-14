package com.eden.bookcase.repository;

import com.eden.bookcase.domain.UserEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MemoryUserRepository implements UserRepository {

  private Map<String, UserEntity> users = new HashMap<>();

  @Override
  public UserEntity save(UserEntity userEntity) {
    users.put(userEntity.getId(), userEntity);
    return userEntity;
  }

  @Override
  public <S extends UserEntity> Iterable<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<UserEntity> findById(String id) {
//    return users.get(id);
    return null;
  }

  @Override
  public boolean existsById(String s) {
    return false;
  }

  @Override
  public Iterable<UserEntity> findAll() {
    return null;
  }

  @Override
  public Iterable<UserEntity> findAllById(Iterable<String> strings) {
    return null;
  }

  @Override
  public long count() {
    return 0;
  }

  @Override
  public void deleteById(String s) {

  }

  @Override
  public void delete(UserEntity entity) {

  }

  @Override
  public void deleteAllById(Iterable<? extends String> strings) {

  }

  @Override
  public void deleteAll(Iterable<? extends UserEntity> entities) {

  }

  @Override
  public void deleteAll() {

  }

  @Override
  public Optional<UserEntity> findByEmail(String username) {
    return null;
  }
}
