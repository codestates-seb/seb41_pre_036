package com.codestates.preproject.vote.Repository;

import com.codestates.preproject.vote.entity.VoteEntity;
import com.codestates.preproject.vote.entity.VoteId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteRepository extends JpaRepository <VoteEntity, VoteId> {
    List<VoteEntity> findByVoteId(VoteId voteId);

}
