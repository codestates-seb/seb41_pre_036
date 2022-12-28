package com.codestates.preproject.question.dto;

import com.codestates.preproject.answer.dto.response.AnswerResponseDto;
import com.codestates.preproject.tag.dto.TagDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class QuestionDto {
    @Getter
    @AllArgsConstructor
    public static class Post {
        @Positive
        private Long member_id;

        @NotBlank(message = "제목은 필수 입력 항목입니다")
        @Length(min = 15, max = 150, message = "제목은 최소 15글자 ~ 최대 150글자로 구성됩니다")
        private String questionTitle;

        @NotBlank(message = "본문은 필수 입력 항목입니다")
        @Length(min = 30, max = 30000, message = "본문은 최소 30글자 ~ 최대 30000글자로 구성됩니다")
        private String questionContent;

        @NotEmpty(message = "태그는 반드시 1개 이상 입력해야 합니다")
        private List<TagDto.Request> tags;
    }

    @Getter
    @AllArgsConstructor
    public static class Patch {
        @Positive
        private Long questionId;


        @Length(min = 15, max = 150, message = "제목은 최소 15글자 ~ 최대 150글자로 구성됩니다")
        private String questionTitle;


        @Length(min = 30, max = 30000, message = "본문은 최소 30글자 ~ 최대 30000글자로 구성됩니다")
        private String questionContent;

        @NotEmpty(message = "태그는 반드시 1개 이상 입력해야 합니다")
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
        private Long member_id;
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
        private Long member_id;
        private String nickname;
        private String questionTitle;
        private String questionContent;
        private Long views;
        private List<TagDto.Response> tags;
        private List<AnswerResponseDto> answers;
        private Long answerCount;
        private LocalDateTime createdAt;
        private LocalDateTime lastModifiedAt;
    }
}
