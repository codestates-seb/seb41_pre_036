package com.codestates.preproject.member.mapper;

import com.codestates.preproject.member.dto.request.MemberPostReqDto;
import com.codestates.preproject.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostReqDto memberPostReqDto);

}
