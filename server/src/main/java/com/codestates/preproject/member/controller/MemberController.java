package com.codestates.preproject.member.controller;

import com.codestates.preproject.member.dto.request.MemberPostReqDto;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.member.mapper.MemberMapper;
import com.codestates.preproject.member.service.MemberService;
import com.codestates.preproject.question.entity.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("v1/members")
@RestController
@Validated
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper){
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostReqDto memberPostReqDto){
        Member member = memberMapper.memberPostDtoToMember(memberPostReqDto);
        Member response = memberService.createMember(member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
