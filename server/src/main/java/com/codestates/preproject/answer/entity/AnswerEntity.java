package com.codestates.preproject.answer.entity;

import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.question.entity.Question;
import com.codestates.preproject.vote.entity.VoteEntity;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_id;

    @ManyToOne
    @JoinColumn (name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @OneToMany(mappedBy = "answerEntity", cascade = CascadeType.PERSIST)
    private List<VoteEntity> votes = new ArrayList<>();

    @Column(length = 200)
    private String answer_content;

    @Column(name = "answer_created_at" , nullable = false)
    private LocalDateTime answer_created_at = LocalDateTime.now();

    @Column(name = "answer_last_modified_at" , nullable = false)
    private LocalDateTime answer_last_modified_at = LocalDateTime.now();

    public String getUserNickname() {
        return member.getUserNickname();
    }

    public Long getVoteCount() {
        Long voteCount = 0L;
        for (VoteEntity vote : votes) {
            voteCount += vote.getOpinion();
        }
        return voteCount;
    }

    public Long getQuestionId() {
        return question.getQuestion_id();
    }

    public Long getMember_id() {
        return member.getMember_id();
    }
}
