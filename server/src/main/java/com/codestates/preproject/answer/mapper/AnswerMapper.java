package com.codestates.preproject.answer.mapper;

import com.codestates.preproject.answer.dto.request.AnswerPatchReqDto;
import com.codestates.preproject.answer.dto.request.AnswerPostReqDto;
import com.codestates.preproject.answer.dto.response.AnswerPatchResDto;
import com.codestates.preproject.answer.dto.response.AnswerPostResDto;
import com.codestates.preproject.answer.dto.response.AnswerResponseDto;
import com.codestates.preproject.answer.entity.AnswerEntity;
import jdk.dynalink.linker.LinkerServices;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface AnswerMapper {

    AnswerEntity answerPostDtoTOAnswerEntity(AnswerPostReqDto answerPostReqDto);
    AnswerEntity answerPatchDtoToAnswerEntity (AnswerPatchReqDto answerPatchReqDto);

    AnswerResponseDto answerEntityToAnswerResponse(AnswerEntity answerEntity);

    List<AnswerResponseDto>answerEntityToAnswerResponses(List<AnswerEntity> answerEntities);



}
