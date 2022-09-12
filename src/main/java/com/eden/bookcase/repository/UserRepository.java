package com.eden.bookcase.repository;

import com.eden.bookcase.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {


  UserEntity findByEmail(String username);

}
