package com.codestates.preproject.member.service;

import com.codestates.preproject.exception.BusinessLogicException;
import com.codestates.preproject.exception.ExceptionCode;
import com.codestates.preproject.member.dto.MemberResponseDto;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.member.mapper.MemberMapper;
import com.codestates.preproject.member.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.providers.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Transactional
@Service
public class MemberService {
    private final com.codestates.preproject.member.repository.MemberRepository MemberRepository;

    private final PasswordEncoder passwordEncoder;
//    private final CustomAuthorityUtils authorityUtils;
    private final MemberMapper memberMapper;

    public MemberService(MemberRepository MemberRepository, PasswordEncoder passwordEncoder, MemberMapper MemberMapper) {
        this.MemberRepository = MemberRepository;
        this.passwordEncoder = passwordEncoder;
//        this.authorityUtils = authorityUtils;
        this.memberMapper = MemberMapper;
    }

    public Member createMember(Member member) {

        //등록된 이메일 확인
        verifyExistsEmail(member.getEmail());
        //Password 암호화
        String encryptedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encryptedPassword);

        return MemberRepository.save(member);
    }

    public Member findMember(Long member_id) {
        return findVerifiedMemberById(member_id);
    }

    public Page<Member> findMembers(int page, int size) {
        return MemberRepository.findAll(PageRequest.of(page, size, Sort.by("createdAt").descending()));
    }

    // 전체조회 service
    public List<MemberResponseDto> findAllMembers() {
        List<Member> memberList = MemberRepository.findAll();
        List<MemberResponseDto> memberDtoList = new ArrayList<>();
        for (Member member : memberList){
            MemberResponseDto memberResponseDto = memberMapper.memberToMemberResponseDto(member);
            memberDtoList.add(memberResponseDto);
        }
        return memberDtoList;
    }


    public Member updateMember(Member member) {
        Member foundMember = findMember(member.getMember_id());
        //user 권한 확인
        verifyMemberAuthorization(member.getMember_id(), foundMember.getMember_id());

        Optional.ofNullable(member.getEmail())
                .ifPresent(foundMember::setEmail);
        Optional.ofNullable(member.getUserNickname())
                .ifPresent(foundMember::setUserNickname);
        Optional.ofNullable(member.getPassword())
                .ifPresent(foundMember::setPassword);

        return saveMember(foundMember);
    }



    public void deleteMember(Long member_id) {
        Member member = findVerifiedMemberById(member_id);
        verifyMemberAuthorization(member_id, findMember(member.getMember_id()).getMember_id());

        MemberRepository.delete(member);
    }


    private Member findVerifiedMemberById(Long member_id) {
        Optional<Member> optionalMember = MemberRepository.findById(member_id);
        Member foundMember = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));

        return foundMember;
    }

    public Member saveMember(Member member) {
        return MemberRepository.saveAndFlush(member);
    }

    public void verifyMemberAuthorization(Long authorizedMember_id, Long tryingMember_id) {
        //member의 권한 확인
        if (!Objects.equals(authorizedMember_id, tryingMember_id))
            throw new BusinessLogicException(ExceptionCode.UNAUTHORIZED_MEMBER);
    }

    private void verifyExistsEmail(String email) {

        Optional<Member> member = com.codestates.preproject.member.repository.MemberRepository.findByEmail(email);

        if (member.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }

    public String getLoginMember() {
        return getMemberByToken();
    }

    public String getMemberByToken() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String membername = (String) principal;
        return membername;
    }


    public String getUserNickname(Long member_id){
        Member member = findMember(member_id);
        String foundUserNickname = member.getUserNickname();

        return foundUserNickname;
    }

}
