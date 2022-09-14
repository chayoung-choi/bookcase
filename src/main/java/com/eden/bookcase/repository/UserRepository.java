package com.eden.bookcase.repository;

import com.eden.bookcase.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, String> {


  Optional<UserEntity> findByEmail(String username);

}
