package com.eden.bookcase.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
  /* 400 BAD_REQUEST : 잘못된 요청 */
  INVALID_REFRESH_TOKEN(HttpStatus.BAD_REQUEST, "리프레시 토큰이 유효하지 않습니다"),
  MISMATCH_REFRESH_TOKEN(HttpStatus.BAD_REQUEST, "리프레시 토큰의 유저 정보가 일치하지 않습니다"),
  CANNOT_FOLLOW_MYSELF(HttpStatus.BAD_REQUEST, "자기 자신은 팔로우 할 수 없습니다"),

  /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
  INVALID_AUTH_TOKEN(HttpStatus.UNAUTHORIZED, "권한 정보가 없는 토큰입니다"),
  UNAUTHORIZED_MEMBER(HttpStatus.UNAUTHORIZED, "현재 내 계정 정보가 존재하지 않습니다"),

  /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
  MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 유저 정보를 찾을 수 없습니다"),
  REFRESH_TOKEN_NOT_FOUND(HttpStatus.NOT_FOUND, "로그아웃 된 사용자입니다"),
  NOT_FOLLOW(HttpStatus.NOT_FOUND, "팔로우 중이지 않습니다"),

  /* 409 CONFLICT : Resource 의 현재 상태와 충돌 */
  CONFLICT_EMAIL(HttpStatus.CONFLICT, "이미 존재하는 이메일입니다"),


  /* 500 INTERNAL_SERVER_ERROR : 서버 오류 */
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류입니다"),

  ;

  private final HttpStatus httpStatus;
  private final String message;
}
