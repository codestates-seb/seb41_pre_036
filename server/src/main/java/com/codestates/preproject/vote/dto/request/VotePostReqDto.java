package com.codestates.preproject.vote.dto.request;

import com.codestates.preproject.vote.annotation.VoteOpinion;
//import com.codestates.preproject.vote.entity.VoteId;
import com.codestates.preproject.vote.enums.OpinionEnum;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VotePostReqDto {


    @Positive
    private Long member_id;

    @Positive
    private Long answer_id;

    @VoteOpinion
    private Integer opinion;

}
