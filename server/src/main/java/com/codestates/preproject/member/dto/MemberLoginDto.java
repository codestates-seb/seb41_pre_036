package com.codestates.preproject.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberLoginDto {
        private String email;
        private String password;

        public MemberLoginDto(String email, String password) {
                this.email = email;
                this.password = password;
        }
}

