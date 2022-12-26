package com.codestates.preproject.vote.mapper;

import com.codestates.preproject.vote.dto.VoteDto;
import com.codestates.preproject.vote.entity.Vote;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoteMapper {
//    VoteDto.Response voteToVoteResponseDto(Vote vote);
    List<VoteDto.Response> votesToVoteResponseDtos(List<Vote> votes);
}
