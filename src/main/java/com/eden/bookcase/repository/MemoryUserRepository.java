package com.eden.bookcase.repository;

import com.eden.bookcase.domain.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class MemoryUserRepository implements UserRepository {

  private Map<String, UserEntity> users = new HashMap<>();

  @Override
  public UserEntity save(UserEntity userEntity) {
    users.put(userEntity.getId(), userEntity);
    return userEntity;
  }

  @Override
  public Optional<UserEntity> findByEmail(String username) {
    return Optional.empty();
  }

  @Override
  public List<UserEntity> findAll() {
    return null;
  }

  @Override
  public List<UserEntity> findAll(Sort sort) {
    return null;
  }

  @Override
  public Page<UserEntity> findAll(Pageable pageable) {
    return null;
  }

  @Override
  public List<UserEntity> findAllById(Iterable<String> strings) {
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
  public <S extends UserEntity> List<S> saveAll(Iterable<S> entities) {
    return null;
  }

  @Override
  public Optional<UserEntity> findById(String s) {
    return Optional.empty();
  }

  @Override
  public boolean existsById(String s) {
    return false;
  }

  @Override
  public void flush() {

  }

  @Override
  public <S extends UserEntity> S saveAndFlush(S entity) {
    return null;
  }

  @Override
  public <S extends UserEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
    return null;
  }

  @Override
  public void deleteAllInBatch(Iterable<UserEntity> entities) {

  }

  @Override
  public void deleteAllByIdInBatch(Iterable<String> strings) {

  }

  @Override
  public void deleteAllInBatch() {

  }

  @Override
  public UserEntity getOne(String s) {
    return null;
  }

  @Override
  public UserEntity getById(String s) {
    return null;
  }

  @Override
  public UserEntity getReferenceById(String s) {
    return null;
  }

  @Override
  public <S extends UserEntity> Optional<S> findOne(Example<S> example) {
    return Optional.empty();
  }

  @Override
  public <S extends UserEntity> List<S> findAll(Example<S> example) {
    return null;
  }

  @Override
  public <S extends UserEntity> List<S> findAll(Example<S> example, Sort sort) {
    return null;
  }

  @Override
  public <S extends UserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
    return null;
  }

  @Override
  public <S extends UserEntity> long count(Example<S> example) {
    return 0;
  }

  @Override
  public <S extends UserEntity> boolean exists(Example<S> example) {
    return false;
  }

  @Override
  public <S extends UserEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
    return null;
  }
}
