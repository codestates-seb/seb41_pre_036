package com.codestates.preproject.answer.mapper;

import com.codestates.preproject.answer.dto.request.AnswerPatchReqDto;
import com.codestates.preproject.answer.dto.request.AnswerPostReqDto;
import com.codestates.preproject.answer.dto.response.AnswerPatchResDto;
import com.codestates.preproject.answer.dto.response.AnswerPostResDto;
import com.codestates.preproject.answer.dto.response.AnswerResponseDto;
import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.question.entity.Question;
import com.codestates.preproject.question.repository.QuestionRepository;
import jdk.dynalink.linker.LinkerServices;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface AnswerMapper {
    default AnswerEntity answerPostDtoTOAnswerEntity(AnswerPostReqDto answerPostReqDto) {
        if ( answerPostReqDto == null ) {
            return null;
        }

        AnswerEntity answerEntity = new AnswerEntity();
//        QuestionRepository questionRepository = null;
//        Question question = questionRepository.getById(answerPostReqDto.getQuestion_id());
        Question question = new Question();
        question.setQuestion_id(answerPostReqDto.getQuestion_id());
        Member member = new Member();
        member.setMember_id(answerPostReqDto.getMember_id());
//        member.setMember_id(question.getMember_id());

        answerEntity.setMember(member);
        answerEntity.setQuestion(question);
        answerEntity.setAnswer_content( answerPostReqDto.getAnswer_content() );

        return answerEntity;
    }
//    AnswerEntity answerPostDtoTOAnswerEntity(AnswerPostReqDto answerPostReqDto);
    AnswerEntity answerPatchDtoToAnswerEntity (AnswerPatchReqDto answerPatchReqDto);

    AnswerResponseDto answerEntityToAnswerResponse(AnswerEntity answerEntity);

    List<AnswerResponseDto>answerEntityToAnswerResponses(List<AnswerEntity> answerEntities);



}
