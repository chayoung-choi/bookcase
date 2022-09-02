package com.eden.bookcase.utils;

import com.eden.bookcase.constants.PasswordStrength;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordMeterTest {
  @Test
  void null_입력() {
    assertPasswordStrength(null, PasswordStrength.INVALID);
  }

  @Test
  void 빈값() {
    assertPasswordStrength("", PasswordStrength.INVALID);
  }

  @Test
  void 모든_규칙_충족() {
    assertPasswordStrength("abcdABCD1234", PasswordStrength.STRONG);
    assertPasswordStrength("1234abcABCD", PasswordStrength.STRONG);
    assertPasswordStrength("ABCD123BCDA", PasswordStrength.STRONG);
  }

  @Test
  void 길이만_충족하지_않는_규칙() {
    assertPasswordStrength("abc12AB", PasswordStrength.NORMAL);
    assertPasswordStrength("12AbCD2", PasswordStrength.NORMAL);
  }

  @Test
  void 숫자만_포함하지_않는_규칙() {
    assertPasswordStrength("abcdABabd", PasswordStrength.NORMAL);
  }

  @Test
  void 대문자만_포함하지_않는_규칙() {
    assertPasswordStrength("abc1231aes2", PasswordStrength.NORMAL);
  }

  @Test
  void 길이만_충족하는_규칙() {
    assertPasswordStrength("abcaesnaews", PasswordStrength.WEAK);
  }

  @Test
  void 숫자만_충족하는_규칙() {
    assertPasswordStrength("abc123", PasswordStrength.WEAK);
  }

  @Test
  void 대문자만_충족하는_규칙() {
    assertPasswordStrength("abcABC", PasswordStrength.WEAK);
  }

  @Test
  void noRules() {
    assertPasswordStrength("abewwe", PasswordStrength.WEAK);
  }

  private void assertPasswordStrength(String password, PasswordStrength expected) {
    PasswordMeter meter = new PasswordMeter();
    PasswordStrength result = meter.meter(password);
    Assertions.assertThat(result).isEqualTo(expected);
  }

}
