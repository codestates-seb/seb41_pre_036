package com.codestates.preproject.answer.entity;

import com.codestates.preproject.audit.Auditable;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.question.entity.Question;
import com.codestates.preproject.vote.entity.Vote;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Answer extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(length = 1000, nullable = false)
    private String answerContent;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public Long getMemberId() {
        return member.getMemberId();
    }

    public String getNickname() {
        return member.getNickname();
    }

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.PERSIST)
    private List<Vote> votes = new ArrayList<>();

    public Long getVoteCount() {
        Long voteCount = 0L;
        for (Vote vote : votes) {
            voteCount += vote.getOpinion();
        }

        return voteCount;
    }

    private Boolean isVoted; // 현재 조회 중인 사람이 이 질문에 대한 투표를 했는지 여부 -> 했다면(그래서 vote opinion 수정이 가능한 경우) true vs false
}
