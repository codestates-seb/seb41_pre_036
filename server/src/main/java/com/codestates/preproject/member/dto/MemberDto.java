package com.codestates.preproject.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    public static MemberDto memberDto;

    private Long member_id;
    private String email;
    private String password;
    public String userNickname;


}


