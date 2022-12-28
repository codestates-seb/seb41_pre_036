package com.codestates.preproject.question.mapper;

import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.question.dto.QuestionDto;
import com.codestates.preproject.question.entity.Question;
import com.codestates.preproject.question.entity.QuestionTag;
import com.codestates.preproject.tag.dto.TagDto;
import com.codestates.preproject.tag.entity.Tag;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    default Question questionPostDtoToQuestion(QuestionDto.Post requestBody) {
        if (requestBody == null) {
            return null;
        }

        Question question = new Question();

        question.setQuestionTitle(requestBody.getQuestionTitle());
        question.setQuestionContent(requestBody.getQuestionContent());

        Member member = new Member();
        member.setMember_id(requestBody.getMember_id());

        if (requestBody.getTags() != null) {
            List<QuestionTag> questionTags = requestBody.getTags().stream().map(tagRequestDto -> {
                QuestionTag questionTag = new QuestionTag();
                Tag tag = new Tag();

                tag.setTagId(tagRequestDto.getTagId());

                questionTag.addQuestion(question);
                questionTag.addTag(tag);
                return questionTag;
            }).collect(Collectors.toList());
            question.setQuestionTags(questionTags);
        } else {
            List<QuestionTag> questionTags = new ArrayList<>();
            question.setQuestionTags(questionTags);
        }

        question.setMember(member);
        return question;
    }


    default Question questionPatchDtoToQuestion(QuestionDto.Patch requestBody) {
        if (requestBody == null) {
            return null;
        } /*lse {
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
            }*/

        Question question = new Question();

        question.setQuestion_id(requestBody.getQuestionId());
        question.setQuestionTitle(requestBody.getQuestionTitle());
        question.setQuestionContent(requestBody.getQuestionContent());

        if (requestBody.getTags() != null) {
            List<QuestionTag> questionTags = requestBody.getTags().stream().map(tagRequestDto -> {
                QuestionTag questionTag = new QuestionTag();
                Tag tag = new Tag();

                tag.setTagId(tagRequestDto.getTagId());

                questionTag.addQuestion(question);
                questionTag.addTag(tag);
                return questionTag;
            }).collect(Collectors.toList());
            question.setQuestionTags(questionTags);
        } else {
            List<QuestionTag> questionTags = new ArrayList<>();
            question.setQuestionTags(questionTags);
        }

        return question;
    }

    default QuestionDto.SimpleResponse questionToQuestionSimpleResponseDto(Question question) {
        if (question == null) {
            return null;
        }

        QuestionDto.SimpleResponse simpleResponse = new QuestionDto.SimpleResponse();

        simpleResponse.setQuestionId(question.getQuestion_id());
        simpleResponse.setMember_id(question.getMember_id());
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

 //       simpleResponse.setAnswerCount(question.getAnswerCount());
        simpleResponse.setCreatedAt(question.getCreatedAt());
        simpleResponse.setLastModifiedAt(question.getLastModifiedAt());

        return simpleResponse;
    }

    //    @Mapping(source = "member.memberId", target = "memberId")
  /*  default QuestionDto.DetailResponse questionToQuestionDetailResponseDto(Question question) {
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

    default List<AnswerDto.Response> answerListToResponseList(List<AnswerEntity> list) {
        if (list == null) {
            return null;
        } else {
            List<AnswerDto.Response> list1 = new ArrayList(list.size());
            Iterator var3 = list.iterator();

            while (var3.hasNext()) {
                AnswerEntity answerEntity = (AnswerEntity) var3.next();
                list1.add(this.answerToResponse(answerEntity));
            }

            return list1;
        }
    }

    default AnswerDto.Response answerToResponse(AnswerEntity answer) {
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
    }*/

    List<QuestionDto.SimpleResponse> questionsToQuestionSimpleResponseDtos(List<Question> questions);
}