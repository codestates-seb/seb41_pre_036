package com.codestates.preproject.tag.mapper;

import com.codestates.preproject.tag.dto.TagDto;
import com.codestates.preproject.tag.entity.Tag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TagMapper {
    Tag tagPostDtoToTag(TagDto.Request tagRequestDto);

    TagDto.Response tagToTagResponseDto(Tag tag);
}
