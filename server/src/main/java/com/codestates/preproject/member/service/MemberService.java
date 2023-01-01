package com.codestates.preproject.member.service;

import com.codestates.preproject.auth.utils.CustomAuthorityUtils;
import com.codestates.preproject.exception.BusinessLogicException;
import com.codestates.preproject.exception.ExceptionCode;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;
    private final CustomAuthorityUtils authorityUtils;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, CustomAuthorityUtils authorityUtils) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityUtils = authorityUtils;
    }

    public Member createMember(Member member) {
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        List<String> roles = authorityUtils.createRoles(member.getEmail()); // todo 우리조 애플리케이션 회원 가입 시 email 또는 userNickname 기준? (stack overflow 웹사이트는 email 기준)
        member.setRoles(roles);

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
