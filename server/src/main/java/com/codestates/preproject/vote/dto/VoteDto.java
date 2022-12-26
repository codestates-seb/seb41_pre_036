package com.codestates.preproject.vote.dto;

import com.codestates.preproject.vote.entity.VoteId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

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
