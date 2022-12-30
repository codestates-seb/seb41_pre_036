package com.codestates.preproject.member.entity;

import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.audit.Auditable;
import com.codestates.preproject.question.entity.Question;
import com.codestates.preproject.vote.entity.VoteEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "members")
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long member_id;

    @Column(nullable = false, updatable = false, unique = true)
    private String email;

    @Column(nullable = false, updatable = false)
    private String password;

    @Column
    public String userNickname;


    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<Question> questionList;

    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private List<AnswerEntity> answerList;


    @Builder
    public Member(Long member_id, String email, String password, String userNickname) {
        this.member_id = member_id;
        this.email = email;
        this.password = password;
        this.userNickname = userNickname;
    }

    public void addQuestionList(Question question){
        this.questionList.add(question);
    }

    public void addAnswerList(AnswerEntity answer){
        this.answerList.add(answer);
    }

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<VoteEntity> votes = new ArrayList<>();

}
