package com.codestates.preproject.question.entity;

import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.member.entity.Member;
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
    private Long question_id;

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
    @JoinColumn(name = "member_id")
    @ToString.Exclude
    private Member member;

    public Long getMember_id() {
        return member.getMember_id();
    }

    public String getNickname() {
        return member.getNickname();
    }

    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST, targetEntity = QuestionTag.class, orphanRemoval = true)
    @ToString.Exclude
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<QuestionTag> questionTags = new ArrayList<QuestionTag>();



    @OneToMany(mappedBy = "question", cascade = CascadeType.PERSIST)
    private List<AnswerEntity> answers = new ArrayList<>();

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
/*        this.questionTags = questionTags;
        if (questionTags == null) {
            this.questionTags = questionTags;
        } else {
            this.questionTags.retainAll(questionTags);
            this.questionTags.addAll(questionTags);
        }*/
        this.questionTags.clear();
        if (questionTags != null) {
            this.questionTags.addAll(questionTags);
        }
    }

    @Builder
    public Question(Long questionId, Member member, String questionTitle, String questionContent, List<QuestionTag> questionTags) {
        this.question_id = questionId;
        this.member = member;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.views = 0L;
        this.questionTags = questionTags;
    }

 /*   public String toString() {
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
    }*/
}
