package com.codestates.preproject.vote.entity;

import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@IdClass(VoteId.class)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vote_entity")
@Setter
public class VoteEntity {

    @Id
    private Long member_id;

    @Id
    private Long answer_id;

    private Integer opinion;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "member_id", insertable = false, updatable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "answer_id", insertable = false, updatable = false)
    private AnswerEntity answerEntity;

    public void setMember(Member member) {
        if (member != null) {
            member.getVotes().remove(this);
        }

        this.member = member;
//        this.member.getVotes().add(this);
    }

    public void setAnswerEntity(AnswerEntity answerEntity) {
        if (answerEntity != null) {
            answerEntity.getVotes().remove(this);
        }

        this.answerEntity = answerEntity;
//        this.answerEntity.getVotes().add(this);
    }

}