package com.codestates.preproject.vote.mapper;

import com.codestates.preproject.vote.dto.request.VotePostReqDto;
import com.codestates.preproject.vote.entity.VoteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoteMapper {
    VoteEntity votePostDtoTOVoteEntity(VotePostReqDto votePostReqDto);

}
