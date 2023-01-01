package com.codestates.preproject.question.mapper;

import com.codestates.preproject.question.dto.QuestionTagDto;
import com.codestates.preproject.question.entity.QuestionTag;
import com.codestates.preproject.tag.entity.Tag;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-31T20:30:35+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class QuestionTagMapperImpl implements QuestionTagMapper {

    @Override
    public QuestionTag questionTagRequestDtoToQuestionTag(QuestionTagDto.Request questionTagRequestDto) {
        if ( questionTagRequestDto == null ) {
            return null;
        }

        QuestionTag.QuestionTagBuilder questionTag = QuestionTag.builder();

        questionTag.tag( requestToTag( questionTagRequestDto ) );

        return questionTag.build();
    }

    @Override
    public QuestionTagDto.Response questionTagToQuestionTagResponseDto(QuestionTag questionTag) {
        if ( questionTag == null ) {
            return null;
        }

        QuestionTagDto.Response response = new QuestionTagDto.Response();

        response.setTagId( questionTagTagTagId( questionTag ) );
        response.setTagWord( questionTagTagTagWord( questionTag ) );

        return response;
    }

    protected Tag requestToTag(QuestionTagDto.Request request) {
        if ( request == null ) {
            return null;
        }

        Tag.TagBuilder tag = Tag.builder();

        tag.tagId( request.getTagId() );

        return tag.build();
    }

    private Long questionTagTagTagId(QuestionTag questionTag) {
        if ( questionTag == null ) {
            return null;
        }
        Tag tag = questionTag.getTag();
        if ( tag == null ) {
            return null;
        }
        Long tagId = tag.getTagId();
        if ( tagId == null ) {
            return null;
        }
        return tagId;
    }

    private String questionTagTagTagWord(QuestionTag questionTag) {
        if ( questionTag == null ) {
            return null;
        }
        Tag tag = questionTag.getTag();
        if ( tag == null ) {
            return null;
        }
        String tagWord = tag.getTagWord();
        if ( tagWord == null ) {
            return null;
        }
        return tagWord;
    }
}
