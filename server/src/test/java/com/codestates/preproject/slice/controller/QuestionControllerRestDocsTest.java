//package com.codestates.preproject.slice.controller;
//
//import com.codestates.preproject.question.controller.QuestionController;
//import com.codestates.preproject.question.dto.QuestionDto;
//import com.codestates.preproject.question.entity.Question;
//import com.codestates.preproject.question.mapper.QuestionMapper;
//import com.codestates.preproject.question.service.QuestionService;
//import com.codestates.preproject.tag.dto.TagDto;
//import com.google.gson.Gson;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
//import org.springframework.http.MediaType;
//import org.springframework.restdocs.payload.JsonFieldType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//
//import java.time.LocalDateTime;
//import java.util.Arrays;
//import java.util.List;
//
//import static com.codestates.preproject.utils.ApiDocumentUtils.getRequestPreProcessor;
//import static com.codestates.preproject.utils.ApiDocumentUtils.getResponsePreProcessor;
//import static org.mockito.BDDMockito.given;
//import static org.mockito.Mockito.mock;
//import static org.springframework.restdocs.headers.HeaderDocumentation.responseHeaders;
//import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
//import static org.springframework.restdocs.payload.PayloadDocumentation.*;
//import static org.springframework.restdocs.request.RequestDocumentation.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@WebMvcTest(QuestionController.class)
//@MockBean(JpaMetamodelMappingContext.class)
//@AutoConfigureRestDocs
//public class QuestionControllerRestDocsTest {
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private QuestionService questionService;
//
//    @MockBean
//    private QuestionMapper questionMapper;
//
//    @Autowired
//    private Gson gson;
//
//    @Test
//    void postQuestionTest() throws Exception {
//        // given
//        QuestionDto.Post postDto = new QuestionDto.Post(1L,
//                "질문 제목1 - 이것은 왜 그런가요? oo에 따라 xx를 해봤는데 안 됩니다",
//                "질문 본문1입니다. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. 이것은 왜 그런가요?",
//                Arrays.asList(new TagDto.Request(1L), new TagDto.Request(2L), new TagDto.Request(3L)));
//        String content = gson.toJson(postDto);
//
//        QuestionDto.SimpleResponse responseDto = new QuestionDto.SimpleResponse(1L,
//                1L,
//                "orangetree",
//                "질문 제목1 - 이것은 왜 그런가요? oo에 따라 xx를 해봤는데 안 됩니다",
//                "질문 본문1입니다. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. 이것은 왜 그런가요?",
//                0L,
//                List.of(new TagDto.Response(1L, "JavaScript"), new TagDto.Response(2L, "Java"), new TagDto.Response(3L, "SQL")),
//                0L,
//                LocalDateTime.now(),
//                LocalDateTime.now());
//
//        given(questionMapper.questionPostDtoToQuestion(Mockito.any(QuestionDto.Post.class))).willReturn(new Question());
//
//        Question mockResultQuestion = new Question();
//        mockResultQuestion.setQuestionId(1L);
//        given(questionService.createQuestion(Mockito.any(Question.class), Mockito.anyLong())).willReturn(mockResultQuestion);
//
//        given(questionMapper.questionToQuestionSimpleResponseDto(Mockito.any(Question.class))).willReturn(responseDto);
//
//        // when
//        ResultActions actions = mockMvc.perform(post("/questions")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content)
//        );
//
//        // then
//        actions.andExpect(status().isCreated())
////                .andExpect(header().string("Location", is(startsWith("/questions"))))
//                .andDo(document("post-question",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("questionTitle").type(JsonFieldType.STRING).description("질문 제목"),
//                                        fieldWithPath("questionContent").type(JsonFieldType.STRING).description("질문 본문"),
//                                        fieldWithPath("tags").type(JsonFieldType.ARRAY).description("질문 태그 목록").optional(),
//                                        fieldWithPath("tags[].tagId").type(JsonFieldType.NUMBER).description("태그 식별자").optional()
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("질문 회원 식별자"),
//                                        fieldWithPath("data.nickname").type(JsonFieldType.STRING).description("질문 회원 닉네임"),
//                                        fieldWithPath("data.questionTitle").type(JsonFieldType.STRING).description("질문 제목"),
//                                        fieldWithPath("data.questionContent").type(JsonFieldType.STRING).description("질문 본문"),
//                                        fieldWithPath("data.views").type(JsonFieldType.NUMBER).description("질문 조회 수"),
//                                        fieldWithPath("data.tags").type(JsonFieldType.ARRAY).description("질문 태그 목록"),
//                                        fieldWithPath("data.tags[].tagId").type(JsonFieldType.NUMBER).description("태그 식별자"),
//                                        fieldWithPath("data.tags[].tagWord").type(JsonFieldType.STRING).description("태그 단어"),
//                                        fieldWithPath("data.answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("data.createdAt").type(JsonFieldType.STRING).description("질문 등록일"),
//                                        fieldWithPath("data.lastModifiedAt").type(JsonFieldType.STRING).description("질문 최종 수정일")
//                                )
//                        )
////                        responseHeaders(headerWithName(HttpHeaders.LOCATION).description("Location header; 등록된 리소스의 URI"))
//                ));
//    } // postQuestionTest() 메서드 종료
//
//    @Test
//    void patchQuestionTest() throws Exception {
//        // setup - run test - tear down
//        // given
//        LocalDateTime time1 = LocalDateTime.now();
//        Long questionId = 1L;
//
//        QuestionDto.Patch patchDto = new QuestionDto.Patch(1L, "질문1 제목 수정 - 저것은 무엇인가요? 차이점이 궁금합니다", "질문1 본문 수정합니다. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like). 저것은 무엇인가요?", Arrays.asList(new TagDto.Request(4L), new TagDto.Request(2L)));
//        String content = gson.toJson(patchDto);
//
//        QuestionDto.SimpleResponse responseDto = new QuestionDto.SimpleResponse(1L,
//                1L,
//                "orangetree",
//                "질문1 제목 수정 - 저것은 무엇인가요? 차이점이 궁금합니다",
//                "질문1 본문 수정합니다. It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like). 저것은 무엇인가요?",
//                0L,
//                Arrays.asList(new TagDto.Response(4L, "Spring"), new TagDto.Response(2L, "Java")),
//                5L,
//                time1,
//                LocalDateTime.now());
//
//        given(questionMapper.questionPatchDtoToQuestion(Mockito.any(QuestionDto.Patch.class))).willReturn(new Question());
//        given(questionService.updateQuestion(Mockito.any(Question.class))).willReturn(new Question());
//        given(questionMapper.questionToQuestionSimpleResponseDto(Mockito.any(Question.class))).willReturn(responseDto);
//
//        // when
//        ResultActions actions = mockMvc.perform(patch("/questions/{question-id}", questionId)
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content));
//
//        // then
//        actions.andExpect(status().isOk())
////                .andExpect(header().string("Location", is(startsWith("/questions"))))
//                .andDo(document("patch-question",
//                        getRequestPreProcessor(),
//                        getResponsePreProcessor(),
//                        pathParameters(parameterWithName("question-id").description("질문 식별자")),
//                        requestFields(
//                                List.of(
//                                        fieldWithPath("questionId").type(JsonFieldType.NUMBER).description("질문 식별자").ignored(),
////                                        fieldWithPath("memberId").type(JsonFieldType.NUMBER).description("회원 식별자"),
//                                        fieldWithPath("questionTitle").type(JsonFieldType.STRING).description("질문 제목"),
//                                        fieldWithPath("questionContent").type(JsonFieldType.STRING).description("질문 본문"),
//                                        fieldWithPath("tags").type(JsonFieldType.ARRAY).description("질문 태그 목록").optional(),
//                                        fieldWithPath("tags[].tagId").type(JsonFieldType.NUMBER).description("태그 식별자").optional()
//                                )
//                        ),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("질문 회원 식별자"),
//                                        fieldWithPath("data.nickname").type(JsonFieldType.STRING).description("질문 회원 닉네임"),
//                                        fieldWithPath("data.questionTitle").type(JsonFieldType.STRING).description("질문 제목"),
//                                        fieldWithPath("data.questionContent").type(JsonFieldType.STRING).description("질문 본문"),
//                                        fieldWithPath("data.views").type(JsonFieldType.NUMBER).description("질문 조회 수"),
//                                        fieldWithPath("data.tags").type(JsonFieldType.ARRAY).description("질문 태그 목록"),
//                                        fieldWithPath("data.tags[].tagId").type(JsonFieldType.NUMBER).description("태그 식별자"),
//                                        fieldWithPath("data.tags[].tagWord").type(JsonFieldType.STRING).description("태그 단어"),
//                                        fieldWithPath("data.answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("data.createdAt").type(JsonFieldType.STRING).description("질문 등록일"),
//                                        fieldWithPath("data.lastModifiedAt").type(JsonFieldType.STRING).description("질문 최종 수정일")
//                                )
//                        )
//                ));
//    } // patchQuestionTest() 메서드 종료
//
//    @Test
//    void getQuestionTest() throws Exception {
//        Long questionId = 1L;
//
//        QuestionDto.DetailResponse responseDto = new QuestionDto.DetailResponse(1L,
//                1L,
//                "orangetree",
//                "질문 제목1 - 이것은 왜 그런가요? oo에 따라 xx를 해봤는데 안 됩니다",
//                "질문 본문1입니다. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. 이것은 왜 그런가요?",
//                14L,
//                List.of(new TagDto.Response(1L, "JavaScript"), new TagDto.Response(2L, "Java"), new TagDto.Response(3L, "SQL")),
//                List.of(
//                        new AnswerDto.Response(1L,
//                                2L,
//                                "purplegrape"
//                                , 1L,
//                                "질문1에 대한 회원2의 답변글(1)입니다",
//                                3L,
//                                false,
//                                LocalDateTime.now(),
//                                LocalDateTime.now()
//                        ),
//                        new AnswerDto.Response(2L,
//                                3L,
//                                "yellowflower",
//                                1L,
//                                "질문1에 대한 회원3의 답변글(2)입니다",
//                                1L,
//                                true,
//                                LocalDateTime.now(),
//                                LocalDateTime.now()
//                        ),
//                        new AnswerDto.Response(3L,
//                                4L,
//                                "greencomputer",
//                                1L,
//                                "질문1에 대한 회원4의 답변글(3)입니다",
//                                -1L,
//                                true,
//                                LocalDateTime.now(),
//                                LocalDateTime.now()
//                        )
//                ),
//                3L,
//                LocalDateTime.now(),
//                LocalDateTime.now()
//        );
//
//        given(questionService.findQuestion(Mockito.anyLong())).willReturn(new Question());
//        given(questionMapper.questionToQuestionDetailResponseDto(Mockito.any(Question.class))).willReturn(responseDto);
//
//        // when
//        ResultActions actions = mockMvc.perform(get("/questions/{question-id}", questionId).accept(MediaType.APPLICATION_JSON));
//
//        // then
//        actions.andExpect(status().isOk())
//                .andExpect(jsonPath("$.data.questionId").value(questionId))
//                .andDo(document("get-question",
//                        getResponsePreProcessor(),
//                        pathParameters(parameterWithName("question-id").description("질문 식별자")),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.OBJECT).description("결과 데이터"),
//                                        fieldWithPath("data.questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                        fieldWithPath("data.memberId").type(JsonFieldType.NUMBER).description("질문 회원 식별자"),
//                                        fieldWithPath("data.nickname").type(JsonFieldType.STRING).description("질문 회원 닉네임"),
//                                        fieldWithPath("data.questionTitle").type(JsonFieldType.STRING).description("질문 제목"),
//                                        fieldWithPath("data.questionContent").type(JsonFieldType.STRING).description("질문 본문"),
//                                        fieldWithPath("data.views").type(JsonFieldType.NUMBER).description("질문 조회 수"),
//                                        fieldWithPath("data.tags").type(JsonFieldType.ARRAY).description("질문 태그 목록"),
//                                        fieldWithPath("data.tags[].tagId").type(JsonFieldType.NUMBER).description("태그 식별자"),
//                                        fieldWithPath("data.tags[].tagWord").type(JsonFieldType.STRING).description("태그 단어"),
//                                        fieldWithPath("data.answers").type(JsonFieldType.ARRAY).description("답변 목록").optional(),
//                                        fieldWithPath("data.answers[].answerId").type(JsonFieldType.NUMBER).description("답변 식별자").optional(),
//                                        fieldWithPath("data.answers[].memberId").type(JsonFieldType.NUMBER).description("답변 회원 식별자").optional(),
//                                        fieldWithPath("data.answers[].nickname").type(JsonFieldType.STRING).description("답변 회원 닉네임").optional(),
//                                        fieldWithPath("data.answers[].questionId").type(JsonFieldType.NUMBER).description("답변 관련 질문 식별자").optional(),
//                                        fieldWithPath("data.answers[].answerContent").type(JsonFieldType.STRING).description("답변 내용").optional(),
//                                        fieldWithPath("data.answers[].voteCount").type(JsonFieldType.NUMBER).description("투표 결과").optional(),
//                                        fieldWithPath("data.answers[].isVoted").type(JsonFieldType.BOOLEAN).description("투표자 여부").optional(),
//                                        fieldWithPath("data.answers[].createdAt").type(JsonFieldType.STRING).description("답변 등록일").optional(),
//                                        fieldWithPath("data.answers[].lastModifiedAt").type(JsonFieldType.STRING).description("답변 최종 수정일").optional(),
//                                        fieldWithPath("data.answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("data.createdAt").type(JsonFieldType.STRING).description("질문 등록일"),
//                                        fieldWithPath("data.lastModifiedAt").type(JsonFieldType.STRING).description("질문 최종 수정일")
//                                )
//                        )
//                ));
//    } // getQuestionTest() 테스트 메서드 종료
//
//    // 기능4a = 'top questions' = 메인페이지 = 질문 전체 조회 + default로 newest순으로 정렬
//    @Test
//    void getQuestionsByCreatedAtTest() throws Exception {
//        // given
//        Integer page = 1;
//        Integer size = 10;
//
//        List<Question> questions = List.of(new Question(), new Question(), new Question());
//
//        List<QuestionDto.SimpleResponse> responseDtos = List.of(
//                new QuestionDto.SimpleResponse(3L, 1L, "orangetree", "질문 제목3", "질문 본문3입니다. 이것은 어떻게 해야할까요?", 10L, List.of(new TagDto.Response(1L, "JavaScript"), new TagDto.Response(2L, "Java"), new TagDto.Response(3L, "SQL")), 3L, LocalDateTime.now(), LocalDateTime.now()),
//                new QuestionDto.SimpleResponse(2L, 2L, "purplegrape", "질문 제목2", "질문 본문2입니다. 저것은 왜 그런 건가요?", 7L, List.of(new TagDto.Response(7L, "C++")), 2L, LocalDateTime.now(), LocalDateTime.now()),
//                new QuestionDto.SimpleResponse(1L, 1L, "orangetree", "질문 제목1", "질문 본문1입니다. 요것은 무엇인가요?", 15L, List.of(new TagDto.Response(4L, "Spring"), new TagDto.Response(5L, "React")), 5L, LocalDateTime.now(), LocalDateTime.now())
//        );
//
//        given(questionService.findQuestionsByCreatedAt(Mockito.anyInt(), Mockito.anyInt())).willReturn(new PageImpl<>(questions, PageRequest.of(page - 1, size, Sort.by("questionId").descending()), questions.size()));
//        given(questionMapper.questionsToQuestionSimpleResponseDtos(Mockito.anyList())).willReturn(responseDtos);
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/questions?page={page}&size={size)}", page, size)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions.andExpect(status().isOk())
//                .andExpect(jsonPath("$.data").isArray())
//                .andDo(document("get-questions",
//                        getResponsePreProcessor(),
//                        requestParameters(List.of(
//                                parameterWithName("page").description("페이지 번호"),
//                                parameterWithName("size").description("페이지 크기"))),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
//                                        fieldWithPath("data[].questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                        fieldWithPath("data[].memberId").type(JsonFieldType.NUMBER).description("질문 회원 식별자"),
//                                        fieldWithPath("data[].nickname").type(JsonFieldType.STRING).description("질문 회원 닉네임"),
//                                        fieldWithPath("data[].questionTitle").type(JsonFieldType.STRING).description("질문 제목"),
//                                        fieldWithPath("data[].questionContent").type(JsonFieldType.STRING).description("질문 본문"),
//                                        fieldWithPath("data[].views").type(JsonFieldType.NUMBER).description("질문 조회 수"),
//                                        fieldWithPath("data[].tags").type(JsonFieldType.ARRAY).description("질문 태그 목록"),
//                                        fieldWithPath("data[].tags[].tagId").type(JsonFieldType.NUMBER).description("태그 식별자"),
//                                        fieldWithPath("data[].tags[].tagWord").type(JsonFieldType.STRING).description("태그 단어"),
//                                        fieldWithPath("data[].answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("data[].createdAt").type(JsonFieldType.STRING).description("질문 등록일"),
//                                        fieldWithPath("data[].lastModifiedAt").type(JsonFieldType.STRING).description("질문 최종 수정일"),
//
//                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지네이션 정보"),
//                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("현재 페이지 번호"),
//                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 크기"),
//                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("데이터 총 개수"),
//                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("총 페이지 수")
//                                )
//                        )
//                ));
//    }
//
//    // 기능4c = '내비게이션 바 검색창' = 특정 검색어 관련 질문 조회 + default로 관련성 내림차순으로 정렬(+newest 등 순으로 조회) = 중요도 '상'
//    // 요청 ur 예시 = https://stackoverflow.com/search?q=java+jpa+sql
//    @Test
//    void searchQuestionsByTitleOrContentTest() throws Exception {
//        // given
//        Integer page = 1;
//        Integer size = 15;
//        String searchText = "Java 자바";
//
//        List<Question> questions = List.of(new Question(), new Question(), new Question());
//
//        List<QuestionDto.SimpleResponse> responseDtos = List.of(
//                new QuestionDto.SimpleResponse(3L, 1L, "orangetree", "Java 질문 제목3", "질문 본문3입니다. 이것은 어떻게 해야할까요?", 16L, List.of(new TagDto.Response(1L, "JavaScript"), new TagDto.Response(2L, "Java"), new TagDto.Response(3L, "SQL")), 11L, LocalDateTime.now(), LocalDateTime.now()),
//                new QuestionDto.SimpleResponse(9L, 2L, "purplegrape", "질문 제목9", "질문 본문9입니다. 자바 저것은 왜 그런 건가요?", 10L, List.of(new TagDto.Response(7L, "C++")), 7L, LocalDateTime.now(), LocalDateTime.now()),
//                new QuestionDto.SimpleResponse(11L, 1L, "orangetree", "질문 제목11", "질문 본문11입니다. java에서 요것은 무엇인가요?", 5L, List.of(new TagDto.Response(4L, "Spring"), new TagDto.Response(5L, "React")), 5L, LocalDateTime.now(), LocalDateTime.now())
//        );
//
//        given(questionService.findQuestionsByTitleOrContent(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt())).willReturn(new PageImpl<>(questions, PageRequest.of(page - 1, size, Sort.by("answerCount").descending()), questions.size()));
//        given(questionMapper.questionsToQuestionSimpleResponseDtos(Mockito.anyList())).willReturn(responseDtos);
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                get("/questions/search?q={searchText}&page={page}&size={size}", searchText, page, size)
//                        .accept(MediaType.APPLICATION_JSON)
//        );
//
//        // then
//        actions.andExpect(status().isOk())
//                .andExpect(jsonPath("$.data").isArray())
//                .andDo(document("search-questions-by-title-or-content",
//                        getResponsePreProcessor(),
//                        requestParameters(List.of(
//                                parameterWithName("q").description("검색어"),
//                                parameterWithName("page").description("페이지 번호"),
//                                parameterWithName("size").description("페이지 크기"))),
//                        responseFields(
//                                List.of(
//                                        fieldWithPath("data").type(JsonFieldType.ARRAY).description("결과 데이터"),
//                                        fieldWithPath("data[].questionId").type(JsonFieldType.NUMBER).description("질문 식별자"),
//                                        fieldWithPath("data[].memberId").type(JsonFieldType.NUMBER).description("질문 회원 식별자"),
//                                        fieldWithPath("data[].nickname").type(JsonFieldType.STRING).description("질문 회원 닉네임"),
//                                        fieldWithPath("data[].questionTitle").type(JsonFieldType.STRING).description("질문 제목"),
//                                        fieldWithPath("data[].questionContent").type(JsonFieldType.STRING).description("질문 본문"),
//                                        fieldWithPath("data[].views").type(JsonFieldType.NUMBER).description("질문 조회 수"),
//                                        fieldWithPath("data[].tags").type(JsonFieldType.ARRAY).description("질문 태그 목록"),
//                                        fieldWithPath("data[].tags[].tagId").type(JsonFieldType.NUMBER).description("태그 식별자"),
//                                        fieldWithPath("data[].tags[].tagWord").type(JsonFieldType.STRING).description("태그 단어"),
//                                        fieldWithPath("data[].answerCount").type(JsonFieldType.NUMBER).description("답변 개수"),
//                                        fieldWithPath("data[].createdAt").type(JsonFieldType.STRING).description("질문 등록일"),
//                                        fieldWithPath("data[].lastModifiedAt").type(JsonFieldType.STRING).description("질문 최종 수정일"),
//
//                                        fieldWithPath("pageInfo").type(JsonFieldType.OBJECT).description("페이지네이션 정보"),
//                                        fieldWithPath("pageInfo.page").type(JsonFieldType.NUMBER).description("현재 페이지 번호"),
//                                        fieldWithPath("pageInfo.size").type(JsonFieldType.NUMBER).description("페이지 크기"),
//                                        fieldWithPath("pageInfo.totalElements").type(JsonFieldType.NUMBER).description("데이터 총 개수"),
//                                        fieldWithPath("pageInfo.totalPages").type(JsonFieldType.NUMBER).description("총 페이지 수")
//                                )
//                        )
//                ));
//    }
//
//    @Test
//    void deleteQuestionTest() throws Exception {
//        // given
//        Long questionId = 1L;
//
////        given(questionService.deleteQuestion(Mockito.anyLong())).willReturn(); // service 관련 메서드에서 반환하는 것 없으니까 작성 필요 없음
//
//        // when
//        ResultActions actions = mockMvc.perform(
//                delete("/questions/{question-id}", questionId));
//
//        // then
//        actions.andExpect(status().isNoContent())
//                .andDo(document("delete-question",
//                        pathParameters(parameterWithName("question-id").description("질문 식별자"))));
//    }
//
//}