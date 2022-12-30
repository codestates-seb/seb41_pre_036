package com.codestates.preproject.member.controller;

import com.codestates.preproject.member.dto.MemberEmailDto;
import com.codestates.preproject.member.dto.MemberPatchDto;
import com.codestates.preproject.member.dto.MemberPostDto;
import com.codestates.preproject.member.dto.MemberResponseDto;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.member.mapper.MemberMapper;
import com.codestates.preproject.member.repository.MemberRepository;
import com.codestates.preproject.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;


@RestController
@RequiredArgsConstructor //-> final 필드 에대한 생성자 생성해주는 어노테이션
@RequestMapping("/users")
@Validated
@Slf4j
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired

    private final MemberMapper mapper;
    private final MemberService memberService;

    //회원가입
    @PostMapping("/signup")
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberPostDto) {
        Member member = mapper.memberPostDtoToMember(memberPostDto);
        Member createdMember = memberService.createMember(member);
        MemberResponseDto response = mapper.memberToMemberResponseDto(createdMember);
        return new ResponseEntity<>(
                new ResponseDto(response),
                HttpStatus.CREATED);
    }

    // 개인 회원 정보 수정
    @PatchMapping("/edit/{user-id}")
    public ResponseEntity updateMember(@PathVariable("user-id") Long member_id, @Valid @RequestBody MemberPatchDto MemberPatchDto){
        MemberPatchDto.setMember_id(member_id);
        Member member = memberService.updateMember(mapper.memberPatchDtoToMember(MemberPatchDto));
        return new ResponseEntity<>(
                new ResponseDto(mapper.memberToMemberResponseDto(member))
                , HttpStatus.OK);
    }


    // 개인 이메일 수정
    @PatchMapping("/email/settings/{user-id}")
    public ResponseEntity updateMember(@PathVariable("user-id") @Positive Long member_id,
                                     @Valid @RequestBody MemberEmailDto MemberEmailDto){
        MemberEmailDto.setMember_id(member_id);
        Member member = memberService.updateMember(mapper.memberEmailDtoToMember(MemberEmailDto));
        return new ResponseEntity<>(
                new ResponseDto(mapper.memberToMemberResponseDto(member))
                , HttpStatus.OK);
    }

    //개인 회원 profile(mypage?)
    @GetMapping("/{user-id}")
    public ResponseEntity getMember(@PathVariable("user-id") @Positive Long member_id) {
        Member member = memberService.findMember(member_id);

        return new ResponseEntity<>(
                new ResponseDto(mapper.memberToMemberResponseDto(member)), HttpStatus.OK
        );
    }

    @GetMapping("/info")
    public String getMember(){
        return memberService.getLoginMember();
    }


    // 회원 정보 전부 출력 -  완료
    @GetMapping()
    public List<MemberResponseDto> memberResponseDto() {
        return memberService.findAllMembers();
    }

    // 회원삭제
    @DeleteMapping("/delete/{user-id}")
    public ResponseEntity deleteUser(@PathVariable("user-id") @Positive Long member_id){
        memberService.deleteMember(member_id);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }

    private class ResponseDto {
        public ResponseDto(MemberResponseDto response) {
        }
    }
}
