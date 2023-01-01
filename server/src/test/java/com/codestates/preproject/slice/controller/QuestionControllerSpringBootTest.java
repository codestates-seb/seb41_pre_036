//package com.codestates.preproject.slice.controller;
//
//import com.codestates.preproject.question.dto.QuestionDto;
//import com.codestates.preproject.question.dto.QuestionTagDto;
//import com.codestates.preproject.question.entity.Question;
//import com.codestates.preproject.question.mapper.QuestionMapper;
//import com.codestates.preproject.question.service.QuestionService;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.BDDMockito.given;
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.startsWith;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
//
////@Transactional
////@SpringBootTest
////@AutoConfigureMockMvc
//public class QuestionControllerSpringBootTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private Gson gson;
//
//    @MockBean
//    private QuestionService questionService;
//
//    @Autowired
//    private QuestionMapper questionMapper;
//
//    /*
//    @Test
//    void postQuestionTest() throws Exception {
//        // given
//        QuestionDto.Post post = new QuestionDto.Post(1L, "질문 제목1", "질문 내용1입니다. 이것은 왜 그런가요?", List.of(new QuestionTagDto.Request(1L), new QuestionTagDto.Request(2L), new QuestionTagDto.Request(3L)));
//
//        Question question = questionMapper.questionPostDtoToQuestion(post);
//        question.setQuestionId(1L);
//        given(questionService.createQuestion(Mockito.any(Question.class)).willReturn(question);
//
//        String content = gson.toJson(post);
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                post("/questions")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content)
//        );
//
//        // then
//        actions.andExpect(status().isCreated())
//                .andExpect(header().string("Location", is(startsWith("/questions"))));
//    }
//     */
//
//}
