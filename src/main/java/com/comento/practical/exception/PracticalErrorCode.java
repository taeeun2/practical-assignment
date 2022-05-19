package com.comento.practical.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PracticalErrorCode {
    NO_MANAGER("해당되는 매니저가 없습니다."),
    NO_TASK("해당되는 업무가 없습니다."),

    NO_COMPANY("해당되는 회사가 없습니다."),

    NO_KIND("해당되는 업무종류가 없습니다."),

    DUPLICATE_COMPANY("중복되는 회사가 존재합니다."),

    DUPLICATE_KIND("중복되는 업무 종류가 존재합니다."),
    INTERNAL_SERVER_ERROR("서버에 오류가 발생했습니다."),
    INVALID_REQUEST("잘못된 요청입니다.");
    private final String message;
}
