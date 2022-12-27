package com.codestates.preproject.slice.service;

import com.codestates.preproject.answer.entity.Answer;
import com.codestates.preproject.answervote.entity.AnswerVote;
import com.codestates.preproject.exception.BusinessLogicException;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.question.entity.Question;
import com.codestates.preproject.question.entity.QuestionTag;
import com.codestates.preproject.question.repository.QuestionRepository;
import com.codestates.preproject.question.service.QuestionService;
import com.codestates.preproject.tag.dto.TagDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

//@ExtendWith(MockitoExtension.class)
public class QuestionServiceRestDocsTest {
    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private QuestionService questionService;

//    @Test
    public void 질문등록Test() {
        // given
        Question question = new Question(1L,
                "질문1 jaVA 제목 수정 - 저것은 무엇인가요? 차이점이 궁금합니다",
                "질문1 본문 수정합니다. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like). 저것은 무엇인가요?",
                null,
                10L,
                new Member(1L, "orangetree", List.of(new Question(), new Question()), List.of(new Answer(), new Answer(), new Answer()), List.of(new AnswerVote(), new AnswerVote(), new AnswerVote(), new AnswerVote())),
                List.of(new QuestionTag(), new QuestionTag(), new QuestionTag()),
                List.of(new Answer(), new Answer())
        );

        given(questionRepository.findById(Mockito.anyLong())).willReturn(Optional.of(question));

        // when/then
        assertThrows(BusinessLogicException.class, () -> questionService.createQuestion(question, Mockito.anyLong()));

    }

    //    @Test
    public void updateQuestionTest() {
        // given
        Long questionId = 1L;

        Question question = new Question(1L,
                "질문1 jaVA 제목 수정 - 저것은 무엇인가요? 차이점이 궁금합니다",
                "질문1 본문 수정합니다. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like). 저것은 무엇인가요?",
                null,
                10L,
                new Member(1L, "orangetree", List.of(new Question(), new Question()), List.of(new Answer(), new Answer(), new Answer()), List.of(new AnswerVote(), new AnswerVote(), new AnswerVote(), new AnswerVote())),
                List.of(new QuestionTag(), new QuestionTag(), new QuestionTag()),
                List.of(new Answer(), new Answer())
        );

//        given(questionRepository.save())

        // when/then


    }
}
