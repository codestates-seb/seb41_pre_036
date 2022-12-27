package com.codestates.preproject.vote.controller;

import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.vote.dto.request.VotePostReqDto;
import com.codestates.preproject.vote.dto.response.VotePostResDto;
import com.codestates.preproject.vote.entity.VoteEntity;
import com.codestates.preproject.vote.mapper.VoteMapper;
import com.codestates.preproject.vote.service.VoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("/v1/vote")
@RestController
@Validated
public class VoteController {

    private final VoteService voteService;
    private final VoteMapper voteMapper;

    public VoteController(VoteService voteService, VoteMapper voteMapper){
        this.voteService = voteService;
        this.voteMapper = voteMapper;
    }
    @PostMapping
    public ResponseEntity postVote (@Valid @RequestBody VotePostReqDto votePostReqDto){

        VoteEntity voteEntity = voteMapper.votePostDtoTOVoteEntity(votePostReqDto);
        VoteEntity response = voteService.createVote(voteEntity);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
