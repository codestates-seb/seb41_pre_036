package com.codestates.preproject.vote.mapper;

import com.codestates.preproject.vote.dto.request.VotePostReqDto;
//import com.codestates.preproject.vote.entity.VoteEntity;
import com.codestates.preproject.vote.entity.VoteEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VoteMapper {
    default VoteEntity votePostDtoTOVoteEntity(VotePostReqDto votePostReqDto) {
        if ( votePostReqDto == null ) {
            return null;
        }
        /*
        AnswerEntity answerEntity = new AnswerEntity();
        answerEntity.setAnswer_id(votePostReqDto.getAnswer_id());

        Member member = new Member();
        member.setMember_id(votePostReqDto.getMember_id());

        VoteId voteId = new VoteId();
        voteId.setMember_id(votePostReqDto.getMember_id());
        voteId.setAnswer_id(votePostReqDto.getAnswer_id());
         */

        VoteEntity vote = new VoteEntity();
//        vote.setVoteId(voteId);
        vote.setMember_id(votePostReqDto.getMember_id());
        vote.setAnswer_id(votePostReqDto.getAnswer_id());
        vote.setOpinion( votePostReqDto.getOpinion() );

        return vote;
    }
}