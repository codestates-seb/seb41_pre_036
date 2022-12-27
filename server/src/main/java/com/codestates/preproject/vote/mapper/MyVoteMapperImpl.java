package com.codestates.preproject.vote.mapper;

import com.codestates.preproject.answer.mapper.AnswerMapper;
import com.codestates.preproject.vote.dto.VoteDto;
import com.codestates.preproject.vote.entity.Vote;

import java.util.List;
import java.util.stream.Collectors;

public class MyVoteMapperImpl implements VoteMapper {
    @Override
    public List<VoteDto.Response> votesToVoteResponseDtos(List<Vote> votes) {
        return votes.stream()
                .map(vote -> VoteDto.Response.builder()
                        .voteId(vote.getVoteId())
                        .opinion(vote.getOpinion())
                        .build())
                .collect(Collectors.toList());
    }
}
