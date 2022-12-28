package com.codestates.preproject.vote.entity;

import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.vote.enums.OpinionEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class VoteEntity {

    @EmbeddedId
    private VoteId voteId;

    private Integer opinion;


    @ManyToOne
    @MapsId(value = "answerId")
    @JoinColumn(name = "answer_id")
    private AnswerEntity answerEntity;

    @ManyToOne
    @MapsId(value = "memberId")
    @JoinColumn(name = "member_id")
    private Member member;

    public VoteEntity (VoteId voteId, Integer opinion){
        this.voteId = voteId;
        this.opinion = opinion;
    }
}
