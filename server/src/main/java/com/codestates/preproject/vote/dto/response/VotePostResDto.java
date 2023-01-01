package com.codestates.preproject.vote.dto.response;

import com.codestates.preproject.vote.annotation.VoteOpinion;
import com.codestates.preproject.vote.entity.VoteId;
import com.codestates.preproject.vote.enums.OpinionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VotePostResDto {

    @Positive
    private Long member_id;

    @Positive
    private Long answer_id;

    @VoteOpinion
    private Integer opinion;

}
