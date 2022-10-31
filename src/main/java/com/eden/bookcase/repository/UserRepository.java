package com.eden.bookcase.repository;

import com.eden.bookcase.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {


  Optional<UserEntity> findByEmail(String username);

}
