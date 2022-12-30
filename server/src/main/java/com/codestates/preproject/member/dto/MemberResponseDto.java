package com.codestates.preproject.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class MemberResponseDto {

    private Long member_id;
    private String email;
    private String userNickname;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
