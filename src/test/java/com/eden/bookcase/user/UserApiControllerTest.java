package com.eden.bookcase.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@Sql("classpath:init.sql")
public class UserApiControllerTest {

//  @Autowired
//  private MemberRepository memberRepository;

  @Autowired
  private MockMvc mvc;

  @Test
  void confirm() throws Exception {

//    memberRepository.save(new Member("id", PMemberStatus.WAITING));
//
//    mvc.perform(post("/members/{id}/confirm", "id"))
//            .andExpect(status().isOk());
//
//
//    Member m = memberRepository.findById("");
//    assertThat(m.getStatus()).isEqualTo(MemberStatus.ACTIVE);
  }

}
