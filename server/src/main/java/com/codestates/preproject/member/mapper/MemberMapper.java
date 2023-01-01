package com.codestates.preproject.member.mapper;

import com.codestates.preproject.member.dto.request.MemberPostReqDto;
import com.codestates.preproject.member.dto.response.MemberResDto;
import com.codestates.preproject.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostReqDto memberPostReqDto);

    MemberResDto memberToMemberResponse(Member member);

    List<MemberResDto> memberToMemberResDto(List<Member> members);
}
