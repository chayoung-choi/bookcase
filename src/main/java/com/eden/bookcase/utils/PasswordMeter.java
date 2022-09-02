package com.eden.bookcase.utils;

import com.eden.bookcase.constants.PasswordStrength;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordMeter {
  public PasswordStrength meter(String password) {
    if (password == null) {
      return PasswordStrength.INVALID;
    }
    if (password.isEmpty()) {
      return PasswordStrength.INVALID;
    }

    int metCount = 0;
    if (isContainsDigit(password)) metCount++;
    if (isContainsUppercase(password)) metCount++;
    if (password.length() >= 8) metCount++;
    if (metCount == 0) {
      return PasswordStrength.WEAK;
    }
    if (metCount == 1) {
      return PasswordStrength.WEAK;
    }
    if (metCount == 2) {
      return PasswordStrength.NORMAL;
    }
    return PasswordStrength.STRONG;
  }

  private boolean isContainsDigit(String password) {
    Pattern pattern = Pattern.compile("[0-9]");
    Matcher matcher = pattern.matcher(password);
    return matcher.find();
  }

  private boolean isContainsUppercase(String password) {
    Pattern pattern = Pattern.compile("[A-Z]");
    Matcher matcher = pattern.matcher(password);
    return matcher.find();
  }
}
