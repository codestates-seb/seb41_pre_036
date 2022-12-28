package com.codestates.preproject.vote.mapper;

import com.codestates.preproject.vote.dto.request.VotePostReqDto;
import com.codestates.preproject.vote.entity.VoteEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-28T15:20:19+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class VoteMapperImpl implements VoteMapper {

    @Override
    public VoteEntity votePostDtoTOVoteEntity(VotePostReqDto votePostReqDto) {
        if ( votePostReqDto == null ) {
            return null;
        }

        VoteEntity voteEntity = new VoteEntity();

        voteEntity.setVoteId( votePostReqDto.getVoteId() );
        voteEntity.setOpinion( votePostReqDto.getOpinion() );

        return voteEntity;
    }
}
