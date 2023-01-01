package com.codestates.preproject.auth.utils;

import com.codestates.preproject.auth.userdetails.MemberDetailsService;
import com.codestates.preproject.exception.BusinessLogicException;
import com.codestates.preproject.exception.ExceptionCode;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.member.repository.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Map;
import java.util.Optional;

@Component
@AllArgsConstructor
public class LoggedInMemberInfoUtils {
    private MemberRepository memberRepository;
    private MemberDetailsService memberDetailsService;

    public Long extractMemberId() {
        Map<String, Object> claims;

        try {
            claims = (Map) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new BusinessLogicException(ExceptionCode.AUTHENTICATION_NOT_FOUND);
        }

        return ((Number) claims.get("memberId")).longValue();
    }

    public Member extractMember() {
        String username;

        try {
            username = SecurityContextHolder.getContext().getAuthentication().getName();
            System.out.println("로그인한 회원의 이메일 = " + username); // 로그인한 회원의 이메일 = rainbow@gmail.com
        } catch (Exception e) {
            throw new BusinessLogicException(ExceptionCode.AUTHENTICATION_NOT_FOUND);
        }

        Optional<Member> optionalMember = memberRepository.findByEmail(username);
        Member foundMember = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return foundMember;
    }

    public Member extractMemberDraft() {
        Long memberId = extractMemberId();
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return member;
    }

    /*
    public Optional<Member> extractOptionalMember() {

    }
     */
}
