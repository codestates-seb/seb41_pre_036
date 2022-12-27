package com.codestates.preproject.answer.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerPostReqDto {
    @Positive
    private Long questionId;
    
    @NotBlank
    private String answer_content;


}
