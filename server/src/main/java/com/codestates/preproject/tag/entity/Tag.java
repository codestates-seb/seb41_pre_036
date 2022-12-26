package com.codestates.preproject.tag.entity;

import com.codestates.preproject.audit.Auditable;
import com.codestates.preproject.question.entity.QuestionTag;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
//@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tag extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(length = 255, nullable = false)
    private String tagWord;

    @Builder
    public Tag(Long tagId, String tagWord) {
        this.tagId = tagId;
        this.tagWord = tagWord;
    }

    @OneToMany(mappedBy = "tag", cascade = CascadeType.PERSIST)
    private List<QuestionTag> questionTags = new ArrayList<>();

    public void addQuestionTag(QuestionTag questionTag) {
        this.questionTags.add(questionTag);
        if (questionTag.getTag() != this) {
            questionTag.addTag(this);
        }
    }
}
