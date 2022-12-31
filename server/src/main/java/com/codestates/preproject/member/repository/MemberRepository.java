package com.codestates.preproject.member.repository;

import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
