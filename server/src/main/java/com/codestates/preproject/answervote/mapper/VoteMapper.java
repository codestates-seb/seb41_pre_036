package com.codestates.preproject.answervote.mapper;

import com.codestates.preproject.answervote.dto.VoteDto;
import com.codestates.preproject.answervote.entity.Vote;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoteMapper {
//    VoteDto.Response voteToVoteResponseDto(Vote vote);
    List<VoteDto.Response> votesToVoteResponseDtos(List<Vote> votes);
}
