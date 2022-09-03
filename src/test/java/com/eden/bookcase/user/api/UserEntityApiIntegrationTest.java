package com.eden.bookcase.user.api;

import com.eden.bookcase.domain.UserEntity;
import com.eden.bookcase.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("classpath:init.sql")
public class UserEntityApiIntegrationTest {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private MockMvc mvc;

  @Test
  void confirm() throws Exception {
    // arrange (given)
//    userRepository.save(new UserEntity("id", UserStatus.WAITING));

    // act  (when)
    mvc.perform(post("/members/{id}/confirm", "id"))
        .andExpect(status().isOk());

    // assert  (then)
    UserEntity m = userRepository.findById("id");
//    assertThat(m.getStatus()).isEqualTo(UserStatus.ACTIVE);
  }
}
