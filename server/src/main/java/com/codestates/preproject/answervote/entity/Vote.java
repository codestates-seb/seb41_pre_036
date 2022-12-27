package com.codestates.preproject.answervote.entity;

import com.codestates.preproject.answer.entity.Answer;
import com.codestates.preproject.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@DynamicInsert
//@DynamicUpdate
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Vote {
    // 식별자 방법1)
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long voteId;

    // 식별자 방법2)
    @EmbeddedId
    private VoteId voteId;

    @Column
    private Integer opinion;

    @MapsId(value = "answerId")
    @ManyToOne
    @JoinColumn(name = "ANSWER_ID")
    private Answer answer;

    @MapsId(value = "memberId")
    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public Vote(VoteId voteId, Integer opinion) {
        this.voteId = voteId;
        this.opinion = opinion;
    }

    /* https://techblog.woowahan.com/2595/ 보고 작성했다가 필요 없는 것 같아 주석 처리
    public void setAnswer(Answer answer) {
        if (answer != null) {
            answer.getVotes().remove(this);
        }
        this.answer = answer;
        this.answer.getVotes().add(this);
    }

    public void setMember(Member member) {
        if (member != null) {
            member.getVotes().remove(this);
        }
        this.member = member;
        this.member.getVotes().add(this);
    }
     */
}
