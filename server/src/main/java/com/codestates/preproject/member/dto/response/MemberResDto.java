package com.codestates.preproject.member.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberResDto {
    private Long member_id;
    private String email;
    private String password;
    private String userNickname;
    private String photo;
    private LocalDateTime member_created_at;
    private LocalDateTime member_modified_at;
}
