package com.codestates.preproject.vote.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class VoteId implements Serializable {

    @Column
    private Long member_id;

    @Column
    private Long answer_id;
}
