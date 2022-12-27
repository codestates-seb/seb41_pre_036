package com.codestates.preproject.answer.mapper;

import com.codestates.preproject.answer.dto.AnswerDto;
import com.codestates.preproject.answer.entity.Answer;

import java.util.List;
import java.util.stream.Collectors;

public class MyAnswerMapperImpl/*implements AnswerMapper*/ {
//    @Override
    public List<AnswerDto.Response> answersToAnswerResponseDtos(List<Answer> answers) {
        return answers.stream()
                .map(answer -> AnswerDto.Response.builder()
                        .answerId(answer.getAnswerId())
                        .memberId(answer.getQuestion().getMember().getMemberId())
                        .questionId(answer.getQuestion().getQuestionId())
                        .answerContent(answer.getAnswerContent())
                        .createdAt(answer.getCreatedAt())
                        .lastModifiedAt(answer.getLastModifiedAt())
                        .build())
                .collect(Collectors.toList());
    }
}
