package com.codestates.preproject.answer.controller;

import com.codestates.preproject.answer.dto.request.AnswerPatchReqDto;
import com.codestates.preproject.answer.dto.request.AnswerPostReqDto;
import com.codestates.preproject.answer.dto.response.AnswerPatchResDto;
import com.codestates.preproject.answer.dto.response.AnswerPostResDto;
import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.answer.mapper.AnswerMapper;
import com.codestates.preproject.answer.service.AnswerService;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.question.entity.Question;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RequestMapping("/v1/answers")
@RestController
@Validated
@Api(tags ={"Answer Api"})
public class AnswerController {

    private final AnswerService answerService;
    private final AnswerMapper answerMapper;

    public AnswerController(AnswerService answerService, AnswerMapper answerMapper){
        this.answerService = answerService;
        this.answerMapper = answerMapper;
    }

    @PostMapping
    public ResponseEntity postAnswer(@Valid @RequestBody AnswerPostReqDto answerPostReqDto){

        AnswerEntity answerEntity = answerMapper.answerPostDtoTOAnswerEntity(answerPostReqDto);
        AnswerEntity response = answerService.createAnswer(answerEntity);
        Question tempQ=response.getQuestion();
        tempQ.setMember(response.getMember());
        response.setQuestion(tempQ);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PatchMapping("/{answer_id}")
    public ResponseEntity patchAnswer(@Valid @PathVariable("answer_id") @Positive long answer_id,
                                        @RequestBody AnswerPatchReqDto answerPatchReqDto){
        AnswerEntity answerEntity = answerMapper.answerPatchDtoToAnswerEntity(answerPatchReqDto);
        AnswerEntity response = answerService.updateAnswer(answerEntity);

        return new ResponseEntity<>(answerMapper.answerEntityToAnswerResponse(response),HttpStatus.OK);

    }

    @GetMapping("/{answer_id}")
    public ResponseEntity getAnswer(@PathVariable("answer_id") @Positive long answer_id) {
        AnswerEntity response = answerService.findAnswer(answer_id);

        return new ResponseEntity<>(answerMapper.answerEntityToAnswerResponse(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getAnswers(){
        List<AnswerEntity> answerEntities = answerService.findAnswers();
        return new ResponseEntity<>(answerMapper.answerEntityToAnswerResponses(answerEntities), HttpStatus.OK);
    }

    @DeleteMapping("/{answer_id}")
    public ResponseEntity deleteAnswer(@PathVariable("answer_id")@Positive long answer_id){
        answerService.deleteAnswer(answer_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
