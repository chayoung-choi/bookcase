package com.eden.bookcase.service.impl;

import com.eden.bookcase.constants.ErrorCode;
import com.eden.bookcase.domain.UserEntity;
import com.eden.bookcase.dto.UserDto;
import com.eden.bookcase.exception.BusinessException;
import com.eden.bookcase.repository.UserRepository;
import com.eden.bookcase.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

  private final String CACHE_KEY_USERS = "USERS";
  private final ModelMapper mapper;
  private final UserRepository userRepository;

  @Override
  public UserDto createUser(UserDto userDto) {
    Optional<UserEntity> checkUser = userRepository.findByEmail(userDto.getEmail());
    if (checkUser.isPresent()) {
      throw new BusinessException(ErrorCode.CONFLICT_EMAIL);
    }
    userDto.setId(UUID.randomUUID().toString());
    UserEntity userEntity = mapper.map(userDto, UserEntity.class);

    userRepository.save(userEntity);
    return mapper.map(userEntity, UserDto.class);
  }

  @Cacheable(value = CACHE_KEY_USERS, key = "#id")
  @Transactional(readOnly = true)
  @Override
  public UserDto getUserById(String id) {
    Optional<UserEntity> userEntity = userRepository.findById(id);
    if (userEntity == null) {
      throw new UsernameNotFoundException("찾을 수 없는 사용자입니다.");
    }
    UserDto userDto = mapper.map(userEntity, UserDto.class);
    return userDto;
  }

//  @Override
//  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//    UserEntity userEntity = userRepository.findByEmail(email);
//    if (userEntity == null) {
//      throw new UsernameNotFoundException(email);
//    }
//
//    return new User(userEntity.getEmail(), userEntity.getEncryptedPwd(),
//        true, true, true, true,
//        new ArrayList<>());
//  }


  @Override
  @Cacheable("users")
  @Transactional(readOnly = true)
  public List<UserEntity> getUserByAll() {
    return userRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public UserDto getUserDetailsByEmail(String email) {
    Optional<UserEntity> userEntity = userRepository.findByEmail(email);

    if (userEntity.isPresent()) {
      throw new UsernameNotFoundException(email);
    }

    UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
    return userDto;
  }

  @CachePut(value = CACHE_KEY_USERS, key = "#userDto.id")
  @Override
  public UserDto updateUser(UserDto userDto) {
    UserEntity userEntity = userRepository.findById(userDto.getId()).orElseThrow(() -> {
      throw new BusinessException(ErrorCode.MEMBER_NOT_FOUND);
    });

    userEntity.setName(userDto.getName());
    userRepository.save(userEntity);
    return mapper.map(userEntity, UserDto.class);
  }
}
