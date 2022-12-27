package com.codestates.preproject.answervote.entity;

import lombok.Data;

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
