package com.codestates.preproject.question.entity;

import com.codestates.preproject.answer.entity.Answer;
import com.codestates.preproject.member.entity.Member;
import com.mysql.cj.protocol.ColumnDefinition;
import lombok.*;
//import org.springframework.data.domain.Auditable;
import com.codestates.preproject.audit.Auditable;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(length = 1000, nullable = false)
    private String questionTitle;

    @Column(length = 1000, nullable = false)
    private String questionContent;

    @Column(length = 255)
    private String questionImage;

    @Column
    @ColumnDefault(value = "0")
    private Long views;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    @ToString.Exclude
    private Member member;

    public Long getMemberId() {
        return member.getMemberId();
    }

    public String getNickname() {
        return member.getNickname();
    }

    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST, targetEntity = QuestionTag.class, orphanRemoval = true)
    @ToString.Exclude
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<QuestionTag> questionTags = new ArrayList<>();

    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<Answer> answers = new ArrayList<>();

    public Long getAnswerCount() {
        return answers.stream().count();
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void addQuestionTag(QuestionTag questionTag) {
        this.questionTags.add(questionTag);
        if (questionTag.getQuestion() != this) {
            questionTag.addQuestion(this);
        }
    }

    public void setQuestionTags(List<QuestionTag> questionTags) {
        this.questionTags = questionTags;
    }

    @Builder
    public Question(Long questionId, Member member, String questionTitle, String questionContent, List<QuestionTag> questionTags) {
        this.questionId = questionId;
        this.member = member;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.views = 0L;
        this.questionTags = questionTags;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", questionTitle='" + questionTitle + '\'' +
                ", questionContent='" + questionContent + '\'' +
                ", questionImage='" + questionImage + '\'' +
                ", views=" + views +
                ", member=" + member +
                ", questionTags=" + questionTags +
                ", answers=" + answers +
                '}';
    }
}
