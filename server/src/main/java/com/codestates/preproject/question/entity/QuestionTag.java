package com.codestates.preproject.question.entity;

import com.codestates.preproject.audit.Auditable;
import com.codestates.preproject.tag.entity.Tag;
import lombok.*;

import javax.persistence.*;

@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "QUESTION_TAG")
public class QuestionTag extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionTagId;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    @Setter
    private Question question;

    @ManyToOne
    @JoinColumn(name = "TAG_ID")
    @Setter
    private Tag tag;

    public Long getTagId() {
        return tag.getTagId();
    }

    public String getTagWord() {
        return tag.getTagWord();
    }

    @Builder
    public QuestionTag(Tag tag, Question question) {
        this.tag = tag;
        this.question = question;
    }

    public void addQuestion(Question question) {
        this.question = question;
        if (!this.question.getQuestionTags().contains(this)) {
            this.question.getQuestionTags().add(this);
        }
    }

    public void addTag(Tag tag) {
        this.tag = tag;
        if (!this.tag.getQuestionTags().contains(this)) {
            this.tag.getQuestionTags().add(this);
        }
    }

    @Override
    public String toString() {
        return "QuestionTag{" +
                "questionTagId=" + questionTagId +
                ", question=" + question +
                ", tag=" + tag +
                '}';
    }
}
