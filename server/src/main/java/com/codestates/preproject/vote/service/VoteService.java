package com.codestates.preproject.vote.service;

import com.codestates.preproject.vote.Repository.VoteRepository;
import com.codestates.preproject.vote.entity.VoteEntity;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    public VoteService(VoteRepository voteRepository){
        this.voteRepository = voteRepository;
    }

    public VoteEntity createVote(VoteEntity voteEntity) {
        return voteRepository.save(voteEntity);
    }
}
