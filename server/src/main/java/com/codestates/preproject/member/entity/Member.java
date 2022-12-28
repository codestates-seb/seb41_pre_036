package com.codestates.preproject.member.entity;

import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.question.entity.Question;
import com.codestates.preproject.vote.entity.VoteEntity;
import com.codestates.preproject.vote.entity.VoteId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @Column(length = 255, nullable = false)
    private String nickname;

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<Question> questions = new ArrayList<>();

//    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
//    private List<AnswerEntity> answers = new ArrayList<>();

   // @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
   // private List<VoteEntity> answerVotes = new ArrayList<>();

    public void setQuestion(Question question) {
        questions.add(question);
        if (question.getMember() != this) {
            question.setMember(this);
        }
    }
}
