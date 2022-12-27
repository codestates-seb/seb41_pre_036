package com.codestates.preproject.answervote.dto;

import com.codestates.preproject.answervote.entity.VoteId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class VoteDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Response {
        private VoteId voteId;
        private Integer opinion;
    }
}
