package com.codestates.preproject.member.service;

import com.codestates.preproject.exception.BusinessLogicException;
import com.codestates.preproject.exception.ExceptionCode;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        return memberRepository.save(member);

    }
    public Member findMember(Long member_id) {
        return findVerifiedMember(member_id);
    }

    public Member findVerifiedMember(Long member_id) {
        Optional<Member> optionalMember = memberRepository.findById(member_id);
        Member verifiedMember = optionalMember.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return verifiedMember;
    }
}
