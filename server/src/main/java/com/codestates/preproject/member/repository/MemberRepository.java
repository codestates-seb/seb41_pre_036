package com.codestates.preproject.member.repository;

import com.codestates.preproject.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public static Optional<Member> findByEmail(String email) {
        return null;
    }

    public Optional<Member> findByMemberId(Long member_id);

    public Member findByEmailAndPassword(String email, String password);

    @Query(value = "SELECT email FROM members WHERE members.active != true",nativeQuery = true)
    public Member getOnlyClosedUser(@Param("email") String email);
}