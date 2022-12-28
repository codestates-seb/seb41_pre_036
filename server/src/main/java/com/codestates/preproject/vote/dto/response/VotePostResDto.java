package com.codestates.preproject.vote.dto.response;

import com.codestates.preproject.vote.entity.VoteId;
import com.codestates.preproject.vote.enums.OpinionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
public class VotePostResDto {

    @Positive
    private VoteId voteId;

    private Integer opinion;

}
