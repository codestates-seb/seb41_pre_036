package com.codestates.preproject.member.mapper;


import com.codestates.preproject.member.dto.*;
import com.codestates.preproject.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
  
     Member memberPostDtoToMember(MemberPostDto memberPostDto);
     Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);

     Member memberLoginDtoToMember(MemberLoginDto memberLoginDto);
     Member memberEmailDtoToMember(MemberEmailDto memberEmailDto);
     MemberResponseDto memberToMemberResponseDto(Member member);














}

