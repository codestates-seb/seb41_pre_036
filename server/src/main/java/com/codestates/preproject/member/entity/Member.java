package com.codestates.preproject.member.entity;

import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.audit.Auditable;
import com.codestates.preproject.question.entity.Question;
import com.codestates.preproject.vote.entity.VoteEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String userNickname;

    @Column(length = 200)
    private String photo;

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

    public void addQuestionList(Question question) {
        this.questionList.add(question);
    }

    public void addAnswerList(AnswerEntity answer) {
        this.answerList.add(answer);
    }

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<VoteEntity> votes = new ArrayList<>();

//    @Column(name = "member_created_at", nullable = false)
//    private LocalDateTime member_created_at = LocalDateTime.now();
//    @Column(name = "member_modified_at", nullable = false)
//    private LocalDateTime member_modified_at = LocalDateTime.now();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();
}
