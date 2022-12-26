package com.codestates.preproject.tag.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TagDto {
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
