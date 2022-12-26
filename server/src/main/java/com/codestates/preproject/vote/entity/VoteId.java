package com.codestates.preproject.vote.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class VoteId implements Serializable {
    private Long answerId;
    private Long memberId;

    public VoteId() {
    }

    public VoteId(Long answerId, Long memberId) {
        this.answerId = answerId;
        this.memberId = memberId;
    }
}
