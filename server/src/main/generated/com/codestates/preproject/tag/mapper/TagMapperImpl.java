package com.codestates.preproject.tag.mapper;

import com.codestates.preproject.tag.dto.TagDto;
import com.codestates.preproject.tag.entity.Tag;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-28T15:20:19+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag tagPostDtoToTag(TagDto.Request tagRequestDto) {
        if ( tagRequestDto == null ) {
            return null;
        }

        Tag.TagBuilder tag = Tag.builder();

        tag.tagId( tagRequestDto.getTagId() );

        return tag.build();
    }

    @Override
    public TagDto.Response tagToTagResponseDto(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagDto.Response response = new TagDto.Response();

        response.setTagId( tag.getTagId() );
        response.setTagWord( tag.getTagWord() );

        return response;
    }
}
