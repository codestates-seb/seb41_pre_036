package com.codestates.preproject.answer.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerDetailResDto {
    private Long answer_id;
    private Long member_id;
    private String userNickname;
    private Long questionId;
    private String answer_content;
    private Long voteCount;
        //    private Boolean isVoted;
    private LocalDateTime answer_created_at;
    private LocalDateTime answer_last_modified_at;
}
