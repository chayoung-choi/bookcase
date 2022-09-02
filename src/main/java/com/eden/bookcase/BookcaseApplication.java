package com.eden.bookcase;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookcaseApplication {

  public static void main(String[] args) {
    SpringApplication.run(BookcaseApplication.class, args);
  }

  @Bean
  public ModelMapper mapper() {
    return new ModelMapper();
  }

//  @Bean
//  public BCryptPasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }

}
