package com.codestates.preproject.answer.mapper;

import com.codestates.preproject.answer.dto.request.AnswerPatchReqDto;
import com.codestates.preproject.answer.dto.response.AnswerResponseDto;
import com.codestates.preproject.answer.entity.AnswerEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-28T15:20:19+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class AnswerMapperImpl implements AnswerMapper {

    @Override
    public AnswerEntity answerPatchDtoToAnswerEntity(AnswerPatchReqDto answerPatchReqDto) {
        if ( answerPatchReqDto == null ) {
            return null;
        }

        AnswerEntity answerEntity = new AnswerEntity();

        answerEntity.setAnswer_id( answerPatchReqDto.getAnswer_id() );
        answerEntity.setAnswer_content( answerPatchReqDto.getAnswer_content() );

        return answerEntity;
    }

    @Override
    public AnswerResponseDto answerEntityToAnswerResponse(AnswerEntity answerEntity) {
        if ( answerEntity == null ) {
            return null;
        }

        AnswerResponseDto answerResponseDto = new AnswerResponseDto();

        answerResponseDto.setMember_id( answerEntity.getMember_id() );
        answerResponseDto.setAnswer_id( answerEntity.getAnswer_id() );
        answerResponseDto.setQuestionId( answerEntity.getQuestionId() );
        answerResponseDto.setAnswer_content( answerEntity.getAnswer_content() );
        answerResponseDto.setAnswer_created_at( answerEntity.getAnswer_created_at() );
        answerResponseDto.setAnswer_last_modified_at( answerEntity.getAnswer_last_modified_at() );

        return answerResponseDto;
    }

    @Override
    public List<AnswerResponseDto> answerEntityToAnswerResponses(List<AnswerEntity> answerEntities) {
        if ( answerEntities == null ) {
            return null;
        }

        List<AnswerResponseDto> list = new ArrayList<AnswerResponseDto>( answerEntities.size() );
        for ( AnswerEntity answerEntity : answerEntities ) {
            list.add( answerEntityToAnswerResponse( answerEntity ) );
        }

        return list;
    }
}
