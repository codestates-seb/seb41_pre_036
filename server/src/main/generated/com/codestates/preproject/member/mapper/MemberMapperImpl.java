package com.codestates.preproject.member.mapper;

import com.codestates.preproject.member.dto.MemberEmailDto;
import com.codestates.preproject.member.dto.MemberLoginDto;
import com.codestates.preproject.member.dto.MemberPatchDto;
import com.codestates.preproject.member.dto.MemberPostDto;
import com.codestates.preproject.member.dto.MemberResponseDto;
import com.codestates.preproject.member.entity.Member;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-30T16:52:50+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public Member memberPostDtoToMember(MemberPostDto memberPostDto) {
        if ( memberPostDto == null ) {
            return null;
        }

        Member.MemberBuilder member = Member.builder();

        member.email( memberPostDto.getEmail() );
        member.password( memberPostDto.getPassword() );
        member.userNickname( memberPostDto.getUserNickname() );

        return member.build();
    }

    @Override
    public Member memberPatchDtoToMember(MemberPatchDto memberPatchDto) {
        if ( memberPatchDto == null ) {
            return null;
        }

        Member.MemberBuilder member = Member.builder();

        member.member_id( memberPatchDto.getMember_id() );
        member.email( memberPatchDto.getEmail() );
        member.password( memberPatchDto.getPassword() );
        member.userNickname( memberPatchDto.getUserNickname() );

        return member.build();
    }

    @Override
    public Member memberLoginDtoToMember(MemberLoginDto memberLoginDto) {
        if ( memberLoginDto == null ) {
            return null;
        }

        Member.MemberBuilder member = Member.builder();

        member.email( memberLoginDto.getEmail() );
        member.password( memberLoginDto.getPassword() );

        return member.build();
    }

    @Override
    public Member memberEmailDtoToMember(MemberEmailDto memberEmailDto) {
        if ( memberEmailDto == null ) {
            return null;
        }

        Member.MemberBuilder member = Member.builder();

        member.member_id( memberEmailDto.getMember_id() );
        member.email( memberEmailDto.getEmail() );

        return member.build();
    }

    @Override
    public MemberResponseDto memberToMemberResponseDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberResponseDto memberResponseDto = new MemberResponseDto();

        memberResponseDto.setMember_id( member.getMember_id() );
        memberResponseDto.setEmail( member.getEmail() );
        memberResponseDto.setUserNickname( member.getUserNickname() );
        memberResponseDto.setCreatedAt( member.getCreatedAt() );

        return memberResponseDto;
    }
}
