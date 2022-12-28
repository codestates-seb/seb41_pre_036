package com.codestates.preproject.question.controller;

import com.codestates.preproject.dto.MultiResponseDto;
import com.codestates.preproject.dto.SingleResponseDto;
import com.codestates.preproject.question.dto.QuestionDto;
import com.codestates.preproject.question.entity.Question;
import com.codestates.preproject.question.mapper.QuestionMapper;
import com.codestates.preproject.question.repository.QuestionRepository;
import com.codestates.preproject.question.service.QuestionService;
import com.codestates.preproject.utils.UriCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/questions")
@Validated
public class QuestionController {
    //    private final static String QUESTION_DEFAULT_URL = "/questions";
    private final QuestionService questionService;
    private final QuestionMapper questionMapper;

    public QuestionController(QuestionService questionService, QuestionMapper questionMapper) {
        this.questionService = questionService;
        this.questionMapper = questionMapper;
    }

    // 기능1 = 회원의 질문 등록
    /* 질문에 이미지 첨부 가능
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionDto.Post requestBody,
                                       @RequestPart MultipartFile questionImage) {
        Question question = questionService.createQuestion(questionMapper.questionPostDtoToQuestion(requestBody), questionImage);
        return ResponseEntity.created(getLocation(question.getQuestionId())).build();
    }
     */
    @PostMapping
    public ResponseEntity postQuestion(@Valid @RequestBody QuestionDto.Post requestBody) {
//        System.out.println("postDto에 담긴 회원 식별자 = " + requestBody.getMemberId()); // todo

        // 크리스마스 12h 여기부터 getMemberId() 관련해서 null pointer exception 발생
//        System.out.println("dto로부터 엔티티로 매핑된 회원 식별자 = " + questionMapper.questionPostDtoToQuestion(requestBody).getMemberId()); // todo
        Question question = questionService.createQuestion(questionMapper.questionPostDtoToQuestion(requestBody), requestBody.getMember_id());
//        System.out.println("저장된 질문글의 회원 식별자 = " + question.getMemberId());
        return new ResponseEntity<>(new SingleResponseDto<>(questionMapper.questionToQuestionSimpleResponseDto(question)), HttpStatus.CREATED);
    }

    // 기능2 = 회원의 질문 수정
    @PatchMapping("/{question-id}")
    public ResponseEntity patchQuestion(@PathVariable("question-id") @Positive Long questionId,
                                        @Valid @RequestBody QuestionDto.Patch requestBody) {
        requestBody.setQuestionId(questionId);
        System.out.println(requestBody.getTags().get(0).getTagId()); // todo 수정된 태그 정보는 잘 넘어옴
        Question question = questionService.updateQuestion(questionMapper.questionPatchDtoToQuestion(requestBody));
//        return ResponseEntity.ok(getLocation(question.getQuestionId()));
        return new ResponseEntity<>(new SingleResponseDto<>(questionMapper.questionToQuestionSimpleResponseDto(question)), HttpStatus.OK);
    }

    // 기능3 = 특정 질문 1개 조회
/*    @GetMapping("/{question-id}")
    public ResponseEntity getQuestion(@PathVariable("question-id") @Positive Long questionId) {
//        System.out.println("questionId = " + questionId);
        Question question = questionService.findQuestion(questionId);
        System.out.println("questionTitle = " + question.getQuestionTitle());
        return new ResponseEntity<>(new SingleResponseDto<>(questionMapper.questionToQuestionDetailResponseDto(question)), HttpStatus.OK);
    }*/

    // 기능4a = 'top questions' = 메인페이지 = 질문 전체 조회 + default로 newest순으로 정렬
    @GetMapping()
    public ResponseEntity getQuestionsByCreatedAt(@Positive @RequestParam(required = false, defaultValue = "1") int page,
                                                  @Positive @RequestParam(required = false, defaultValue = "15") int size) {
        Page<Question> pageQuestions = questionService.findQuestionsByCreatedAt(page - 1, size);
        List<Question> questions = pageQuestions.getContent();
        return new ResponseEntity<>(new MultiResponseDto<>(questionMapper.questionsToQuestionSimpleResponseDtos(questions), pageQuestions), HttpStatus.OK);
    }

    // 기능4b = 'questions' = 왼쪽 사이드바 = 질문 전체 조회 + default로 답변 개수 내림차순으로 정렬(+newest, unanswered(no upvoted or accepted answers) 등 순으로 조회) = 중요도 '중'
    // 기능4c = '내비게이션 바 검색창' = 특정 검색어 관련 질문 조회 + default로 관련성 내림차순으로 정렬(+newest 등 순으로 조회) = 중요도 '상'
    // 요청 ur 예시 = https://stackoverflow.com/search?q=java+jpa+sql
    @GetMapping("/search")
    public ResponseEntity searchQuestionsByTitleOrContent(@RequestParam("q") String searchText,
                                                          @Positive @RequestParam(required = false, defaultValue = "1") int page,
                                                          @Positive @RequestParam(required = false, defaultValue = "15") int size) {
        Page<Question> pageQuestions = questionService.findQuestionsByTitleOrContent(searchText, searchText,page - 1, size);
        List<Question> questions = pageQuestions.getContent();
        return new ResponseEntity<>(new MultiResponseDto<>(questionMapper.questionsToQuestionSimpleResponseDtos(questions), pageQuestions), HttpStatus.OK);
    }

    // 기능4d = '사이트 내 태그 클릭' = 특정 태그 관련 질문 조회 + 답변 개수 내림차순으로 정렬

    // 기능5 = 질문 삭제
    @DeleteMapping("/{question-id}")
    public ResponseEntity deleteQuestion(@PathVariable("question-id") @Positive Long questionId) {

        questionService.deleteQuestion(questionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
