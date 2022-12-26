package com.codestates.preproject.question.dto;

import com.codestates.preproject.answer.dto.AnswerDto;
import com.codestates.preproject.answer.entity.Answer;
import com.codestates.preproject.question.entity.QuestionTag;
import com.codestates.preproject.tag.dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class QuestionDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @Positive
        private Long memberId;

        @NotBlank
        private String questionTitle;

        @NotBlank
        private String questionContent;

        @NotNull
        @Valid
        private List<TagDto.Request> tags;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        @Positive
        private Long questionId;

        @NotBlank
        private String questionTitle;

        @NotBlank
        private String questionContent;

        @NotNull
        @Valid
        private List<TagDto.Request> tags;

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SimpleResponse {
        private Long questionId;
        private Long memberId;
        private String nickname;
        private String questionTitle;
        private String questionContent;
        private Long views;
        private List<TagDto.Response> tags;
        private Long answerCount;
        private LocalDateTime createdAt;
        private LocalDateTime lastModifiedAt;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DetailResponse {
        private Long questionId;
        private Long memberId;
        private String nickname;
        private String questionTitle;
        private String questionContent;
        private Long views;
        private List<TagDto.Response> tags;
        private List<AnswerDto.Response> answers;
        private Long answerCount;
        private LocalDateTime createdAt;
        private LocalDateTime lastModifiedAt;
    }
}
