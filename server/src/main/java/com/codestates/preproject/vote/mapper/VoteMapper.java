package com.codestates.preproject.vote.mapper;

import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.vote.dto.request.VotePostReqDto;
import com.codestates.preproject.vote.entity.VoteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoteMapper {
    default VoteEntity votePostDtoTOVoteEntity(VotePostReqDto votePostReqDto) {
        if ( votePostReqDto == null ) {
            return null;
        }
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setAnswer_id(votePostReqDto.getAnswer_id());

        Member member = new Member();
        member.setMember_id(votePostReqDto.getMember_id());

        VoteEntity voteEntity = new VoteEntity();
        voteEntity.setOpinion( votePostReqDto.getOpinion() );

        return voteEntity;
    }
}

