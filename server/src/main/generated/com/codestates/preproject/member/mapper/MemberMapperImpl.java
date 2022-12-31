package com.codestates.preproject.member.mapper;

import com.codestates.preproject.member.dto.request.MemberPostReqDto;
import com.codestates.preproject.member.entity.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-31T20:30:35+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(MemberPostReqDto memberPostReqDto) {
        if ( memberPostReqDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setEmail( memberPostReqDto.getEmail() );
        member.setPassword( memberPostReqDto.getPassword() );
        member.setUserNickname( memberPostReqDto.getUserNickname() );

        return member;
    }
}
