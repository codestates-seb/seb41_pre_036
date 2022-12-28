package com.codestates.preproject.question.mapper;

import com.codestates.preproject.question.dto.QuestionDto;
import com.codestates.preproject.question.entity.Question;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-28T17:09:00+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.16.1 (Azul Systems, Inc.)"
)
@Component
public class QuestionMapperImpl implements QuestionMapper {

    @Override
    public List<QuestionDto.SimpleResponse> questionsToQuestionSimpleResponseDtos(List<Question> questions) {
        if ( questions == null ) {
            return null;
        }

        List<QuestionDto.SimpleResponse> list = new ArrayList<QuestionDto.SimpleResponse>( questions.size() );
        for ( Question question : questions ) {
            list.add( questionToQuestionSimpleResponseDto( question ) );
        }

        return list;
    }
}
