package com.codestates.preproject.member.entity;

import com.codestates.preproject.vote.entity.VoteEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {
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

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<VoteEntity> votes = new ArrayList<>();

    @Column(name = "member_created_at" , nullable = false)
    private LocalDateTime member_created_at = LocalDateTime.now();
    @Column(name = "member_modified_at" , nullable = false)
    private LocalDateTime member_modified_at = LocalDateTime.now();

}
