package com.codestates.preproject.question.mapper;

import com.codestates.preproject.answer.dto.AnswerDto;
import com.codestates.preproject.answer.entity.Answer;
import com.codestates.preproject.question.dto.QuestionDto;
import com.codestates.preproject.question.entity.Question;
import com.codestates.preproject.question.entity.QuestionTag;
import com.codestates.preproject.tag.dto.TagDto;
import com.codestates.preproject.tag.entity.Tag;
import com.codestates.preproject.tag.mapper.TagMapper;
import com.codestates.preproject.tag.mapper.TagMapperImpl;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    default Question questionPostDtoToQuestion(QuestionDto.Post requestBody) {
        if (requestBody == null) {
            return null;
        }

        Question.QuestionBuilder questionBuilder = Question.builder();

        questionBuilder.questionTitle(requestBody.getQuestionTitle());
//        questionBuilder.user(user); //이거 questionService의 createQuetion에서 또 설정한다. 확인요망!!!
        questionBuilder.questionContent(requestBody.getQuestionContent());

        Question question = questionBuilder.build();
        if (requestBody.getTags() != null) {
            TagMapper tapMapper = new TagMapperImpl();

            List<QuestionTag> questionTags = requestBody.getTags().stream()
                    .map(tagRequestDto -> {
                        Tag.TagBuilder tag = Tag.builder();
                        tag.tagId(tagRequestDto.getTagId());

                        QuestionTag.QuestionTagBuilder questionTag = QuestionTag.builder();
//                    questionTag.question(question); //이때 저장된 question은 questionTagList가 저장 안됐는데 괜찮나??
                        questionTag.tag(tag.build());
                        return questionTag.build();
                    }).collect(Collectors.toCollection(ArrayList::new));
            question.setQuestionTags(questionTags);
        } else {
            List<QuestionTag> questionTags = new ArrayList<>();
            question.setQuestionTags(questionTags);
        }
        return question;
    }
    /* 방법1)
    questionPostDto.GetTagDtoList().stream()
        .map(tagDto -> TagMapper.tagDtoToTag(tagDto))
        .map(tag -> {
            // map tag to questionTag
        })
        .collect(...)

    방법2) use a mapper inside another mapper
    questionPostDto.GetTagDtoList().stream()
        .map(tagDto -> TagMapper.tagDtoToTag(tagDto))
        .map(tag -> myCustomQuestionTagMapperFunction(tag))
        .collect(...)
     */

    default Question questionPatchDtoToQuestion(QuestionDto.Patch requestBody) {
        if (requestBody == null) {
            return null;
        } else {
            Question.QuestionBuilder questionBuilder = Question.builder();
            questionBuilder.questionId(requestBody.getQuestionId());
            questionBuilder.questionTitle(requestBody.getQuestionTitle());
            questionBuilder.questionContent(requestBody.getQuestionContent());

            Question question = questionBuilder.build();
            if (requestBody.getTags() != null) {
                TagMapper tapMapper = new TagMapperImpl();

                List<QuestionTag> questionTags = requestBody.getTags().stream()
                        .map(tagRequestDto -> {
                            Tag.TagBuilder tag = Tag.builder();
                            tag.tagId(tagRequestDto.getTagId());

                            QuestionTag.QuestionTagBuilder questionTag = QuestionTag.builder();
                            questionTag.tag(tag.build());
                            return questionTag.build();
                        }).collect(Collectors.toCollection(ArrayList::new));
                question.setQuestionTags(questionTags);
            } else {
                List<QuestionTag> questionTags = new ArrayList<>();
                question.setQuestionTags(questionTags);
            }
            return question;
        }
    }

    default QuestionDto.SimpleResponse questionToQuestionSimpleResponseDto(Question question) {
        if (question == null) {
            return null;
        }

        QuestionDto.SimpleResponse simpleResponse = new QuestionDto.SimpleResponse();

        simpleResponse.setQuestionId(question.getQuestionId());
        simpleResponse.setMemberId(question.getMemberId());
        simpleResponse.setNickname(question.getNickname());
        simpleResponse.setQuestionTitle(question.getQuestionTitle());
        simpleResponse.setQuestionContent(question.getQuestionContent());
        simpleResponse.setViews(question.getViews());

        List<QuestionTag> questionTags = question.getQuestionTags();
        if (questionTags != null && !questionTags.isEmpty()) {
            List<TagDto.Response> tags = questionTags.stream()
                    .map(questionTag -> {
                        TagDto.Response tagResponseDto = new TagDto.Response();
                        tagResponseDto.setTagId(questionTag.getTagId());
                        tagResponseDto.setTagWord(questionTag.getTagWord());
                        return tagResponseDto;
                    }).collect(Collectors.toList());
            simpleResponse.setTags(tags);
        }

        simpleResponse.setAnswerCount(question.getAnswerCount());
        simpleResponse.setCreatedAt(question.getCreatedAt());
        simpleResponse.setLastModifiedAt(question.getLastModifiedAt());

        return simpleResponse;
    }

    //    @Mapping(source = "member.memberId", target = "memberId")
    default QuestionDto.DetailResponse questionToQuestionDetailResponseDto(Question question) {
        if (question == null) {
            return null;
        } else {
            QuestionDto.DetailResponse detailResponse = new QuestionDto.DetailResponse();
            detailResponse.setQuestionId(question.getQuestionId());
            detailResponse.setMemberId(question.getMemberId());
            detailResponse.setNickname(question.getNickname());
            detailResponse.setQuestionTitle(question.getQuestionTitle());
            detailResponse.setQuestionContent(question.getQuestionContent());
            detailResponse.setViews(question.getViews());

            List<QuestionTag> questionTags = question.getQuestionTags();
            if (questionTags != null && !questionTags.isEmpty()) {
                List<TagDto.Response> tags = questionTags.stream()
                        .map(questionTag -> {
                            TagDto.Response tagResponseDto = new TagDto.Response();
                            tagResponseDto.setTagId(questionTag.getTagId());
                            tagResponseDto.setTagWord(questionTag.getTagWord());
                            return tagResponseDto;
                        }).collect(Collectors.toList());
                detailResponse.setTags(tags);
            }

            detailResponse.setAnswers(this.answerListToResponseList(question.getAnswers()));
            detailResponse.setAnswerCount(question.getAnswerCount());
            detailResponse.setCreatedAt(question.getCreatedAt());
            detailResponse.setLastModifiedAt(question.getLastModifiedAt());
            return detailResponse;
        }
    }

    default List<AnswerDto.Response> answerListToResponseList(List<Answer> list) {
        if (list == null) {
            return null;
        } else {
            List<AnswerDto.Response> list1 = new ArrayList(list.size());
            Iterator var3 = list.iterator();

            while (var3.hasNext()) {
                Answer answer = (Answer) var3.next();
                list1.add(this.answerToResponse(answer));
            }

            return list1;
        }
    }

    default AnswerDto.Response answerToResponse(Answer answer) {
        if (answer == null) {
            return null;
        } else {
            AnswerDto.Response.ResponseBuilder response = AnswerDto.Response.builder();
            response.answerId(answer.getAnswerId());
            response.memberId(answer.getMemberId());
            response.nickname(answer.getNickname());
            response.answerContent(answer.getAnswerContent());
            response.voteCount(answer.getVoteCount());
            response.createdAt(answer.getCreatedAt());
            response.lastModifiedAt(answer.getLastModifiedAt());
            return response.build();
        }
    }

    List<QuestionDto.SimpleResponse> questionsToQuestionSimpleResponseDtos(List<Question> questions);
}