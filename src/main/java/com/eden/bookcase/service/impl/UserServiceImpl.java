package com.eden.bookcase.service.impl;

import com.eden.bookcase.domain.UserEntity;
import com.eden.bookcase.dto.UserDto;
import com.eden.bookcase.repository.UserRepository;
import com.eden.bookcase.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

  private ModelMapper mapper;

  private UserRepository userRepository;

  public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
    this.mapper = modelMapper;
    this.userRepository = userRepository;
  }

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
  public UserDto createUser(UserDto userDto) {
    userDto.setId(UUID.randomUUID().toString());

    UserEntity userEntity = mapper.map(userDto, UserEntity.class);

    userRepository.save(userEntity);
    return mapper.map(userEntity, UserDto.class);
  }

  @Override
  public Iterable<UserEntity> getUserByAll() {
    return userRepository.findAll();
  }

  @Override
  public UserDto getUserDetailsByEmail(String email) {
    UserEntity userEntity = userRepository.findByEmail(email);

    if (userEntity == null) {
      throw new UsernameNotFoundException(email);
    }

    UserDto userDto = new ModelMapper().map(userEntity, UserDto.class);
    return userDto;
  }
}
