package com.codestates.preproject.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404,"Member not found"),
    QUESTION_NOT_FOUND(404, "Question not found"),
    TAG_NOT_FOUND(404, "Tag not found"),
    UNAUTHORIZED_MEMBER(403, "Unauthorized member"),
    MEMBER_EXISTS(409, "Member exists"),
    AUTHENTICATION_NOT_FOUND(404, "Authentication not found in SecurityContextHolder"),
    NOT_QUESTION_WRITER(403, "Not question writer");

    @Getter
    private Integer status;

    @Getter
    private String message;

    ExceptionCode(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
