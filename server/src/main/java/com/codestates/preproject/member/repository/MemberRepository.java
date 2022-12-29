package com.codestates.preproject.member.repository;

import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long Member_id);

}
