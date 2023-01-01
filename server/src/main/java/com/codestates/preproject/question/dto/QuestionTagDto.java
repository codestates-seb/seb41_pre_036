package com.codestates.preproject.question.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class QuestionTagDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        @Positive
        private Long tagId;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        @Positive
        private Long tagId;

        @NotBlank
        private String tagWord;
    }
}
