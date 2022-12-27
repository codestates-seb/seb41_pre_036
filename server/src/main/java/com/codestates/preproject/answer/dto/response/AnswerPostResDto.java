package com.codestates.preproject.answer.dto.response;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnswerPostResDto {

    @Positive
    private Long member_id;

    @Positive
    private Long questionId;

    @NotBlank
    private String answer_content;
}
