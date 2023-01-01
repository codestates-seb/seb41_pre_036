package com.codestates.preproject.question.mapper;

import com.codestates.preproject.question.dto.QuestionTagDto;
import com.codestates.preproject.question.entity.QuestionTag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionTagMapper {
    @Mapping(source = "tagId", target = "tag.tagId")
    QuestionTag questionTagRequestDtoToQuestionTag(QuestionTagDto.Request questionTagRequestDto);

    @Mapping(source = "tag.tagId", target = "tagId")
    @Mapping(source = "tag.tagWord", target = "tagWord")
    QuestionTagDto.Response questionTagToQuestionTagResponseDto(QuestionTag questionTag);
}
