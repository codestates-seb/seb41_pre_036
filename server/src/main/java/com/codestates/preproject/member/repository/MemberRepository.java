package com.codestates.preproject.member.repository;

import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String username);
}
