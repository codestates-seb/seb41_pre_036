package com.codestates.preproject.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404,"Member not found"),
    QUESTION_NOT_FOUND(404, "Question not found");

    @Getter
    private Integer status;

    @Getter
    private String message;

    ExceptionCode(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
}
