package com.codestates.preproject.answer.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerPatchReqDto {
    @Positive
    private Long answer_id;

    @NotBlank
    private String answer_content;

}
