package com.codestates.preproject.answer.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerPatchResDto {

    @Positive
    private Long answer_id;

    @NotBlank
    private String answer_content;


}
