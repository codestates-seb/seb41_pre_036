package com.codestates.preproject.answer.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerResponseDto {
    private Long member_id;
    private Long answer_id;
    private Long questionId;
    private Long vote_id;
    private String answer_content;
    private LocalDateTime answer_created_at;
    private LocalDateTime answer_last_modified_at;
}
