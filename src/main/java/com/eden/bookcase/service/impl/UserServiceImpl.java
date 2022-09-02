package com.eden.bookcase.service.impl;

import com.eden.bookcase.domain.UserEntity;
import com.eden.bookcase.dto.UserDto;
import com.eden.bookcase.repository.UserRepository;
import com.eden.bookcase.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

  private ModelMapper modelMapper;

  private UserRepository userRepository;

  public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository) {
    this.modelMapper = modelMapper;
    this.userRepository = userRepository;
  }

  @Override
  public UserDto getUserById(String id) {
    UserEntity userEntity = userRepository.findById(id);
    UserDto userDto = modelMapper.map(userEntity, UserDto.class);
    return userDto;
  }

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserEntity userEntity = userRepository.findByEmail(email);
    if (userEntity == null) {
      throw new UsernameNotFoundException(email);
    }

    return new User(userEntity.getEmail(), userEntity.getEncryptedPwd(),
            true, true, true, true,
            new ArrayList<>());
  }
}
