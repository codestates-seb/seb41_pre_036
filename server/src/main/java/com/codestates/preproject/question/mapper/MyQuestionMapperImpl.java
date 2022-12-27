package com.codestates.preproject.question.mapper;

import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.question.dto.QuestionDto;
import com.codestates.preproject.question.dto.QuestionTagDto;
import com.codestates.preproject.question.entity.Question;
import com.codestates.preproject.question.entity.QuestionTag;
import com.codestates.preproject.tag.entity.Tag;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

//@Component
public class MyQuestionMapperImpl /*implements QuestionMapper*/ {
    public Question questionPostDtoToQuestion(QuestionDto.Post requestBody) {
        Question question = new Question();
        Member member = new Member();
        member.setMemberId(requestBody.getMemberId());
        question.setMember(member);
        question.setQuestionTitle(requestBody.getQuestionTitle());
        question.setQuestionContent(requestBody.getQuestionContent());
/*
        List<QuestionTag> questionTags = requestBody.getTags().stream()
                .map(questionTagRequestDto -> {
                    QuestionTag questionTag = new QuestionTag();
                    Tag tag = new Tag();
                    tag.setTagId(questionTagRequestDto.getTagId());
                    questionTag.setQuestion(question);
                    questionTag.setTag(tag);
                    return questionTag;
                }).collect(Collectors.toList());
        question.setQuestionTags(questionTags);
 */

        return question;
    }

    public Question questionPatchDtoToQuestion(QuestionDto.Patch requestBody) {
        if (requestBody == null) {
            return null;
        } else {
            Question question = new Question();
//            question.setQuestionId(requestBody.getQuestionId());
            question.setQuestionTitle(requestBody.getQuestionTitle());
            question.setQuestionContent(requestBody.getQuestionContent());
//            question.setQuestionTags(this.requestListToQuestionTagList(requestBody.getTags()));
            return question;
        }
    }

    public QuestionDto.SimpleResponse questionToQuestionSimpleResponseDto(Question question) {
        return null;
    }

    public QuestionDto.DetailResponse questionToQuestionDetailResponseDto(Question question) {
        QuestionDto.DetailResponse questionResponseDto = new QuestionDto.DetailResponse();

        questionResponseDto.setQuestionId(question.getQuestionId());
        questionResponseDto.setMemberId(question.getMember().getMemberId());
        questionResponseDto.setQuestionTitle(question.getQuestionTitle());
        questionResponseDto.setQuestionContent(question.getQuestionContent());
        questionResponseDto.setViews(question.getViews());

//        List<QuestionTag> questionTags = question.getQuestionTags();
//        questionResponseDto.setTags(questionTagsToQuestionTagResponseDtos(questionTags));

//        List<Answere> answers = question.getAnswers();
//        AnswerMapper answerMapper = new MyAnswerMapperImpl();
//        questionResponseDto.setAnswers(answerMapper.answersToAnswerResponseDtos(answers));

        questionResponseDto.setCreatedAt(question.getCreatedAt());
        questionResponseDto.setLastModifiedAt(question.getLastModifiedAt());

        return questionResponseDto;
    }

    public QuestionTagDto.Response questionTagToQuestionTagResponseDto(QuestionTag questionTag) {
        if (questionTag == null) {
            return null;
        } else {
            QuestionTagDto.Response response = new QuestionTagDto.Response();
            response.setTagId(this.questionTagTagTagId(questionTag));
            response.setTagWord(this.questionTagTagTagWord(questionTag));
            return response;
        }
    }

    public List<QuestionDto.SimpleResponse> questionsToQuestionSimpleResponseDtos(List<Question> questions) {
        if (questions == null) {
            return null;
        } else {
            List<QuestionDto.SimpleResponse> list = new ArrayList<>(questions.size());
            Iterator var3 = questions.iterator();

            while (var3.hasNext()) {
                Question question = (Question) var3.next();
                list.add(this.questionToQuestionSimpleResponseDto(question));
            }

            return list;
        }
    }

    protected QuestionTag requestToQuestionTag(QuestionTagDto.Request request) {
        if (request == null) {
            return null;
        } else {
            QuestionTag questionTag = new QuestionTag();
            return questionTag;
        }
    }

    protected List<QuestionTag> requestListToQuestionTagList(List<QuestionTagDto.Request> list) {
        if (list == null) {
            return null;
        } else {
            List<QuestionTag> list1 = new ArrayList<>(list.size());
            Iterator var3 = list.iterator();

            while(var3.hasNext()) {
                QuestionTagDto.Request request = (QuestionTagDto.Request)var3.next();
                list1.add(this.requestToQuestionTag(request));
            }

            return list1;
        }
    }

    public List<QuestionTagDto.Response> questionTagsToQuestionTagResponseDtos(List<QuestionTag> questionTags) {
        return questionTags.stream()
                .map(questionTag -> questionTagToQuestionTagResponseDto(questionTag))
                .collect(Collectors.toList());
    }

    private Long questionTagTagTagId(QuestionTag questionTag) {
        if (questionTag == null) {
            return null;
        } else {
            Tag tag = questionTag.getTag();
            if (tag == null) {
                return null;
            } else {
                Long tagId = tag.getTagId();
                return tagId == null ? null : tagId;
            }
        }
    }

    private String questionTagTagTagWord(QuestionTag questionTag) {
        if (questionTag == null) {
            return null;
        } else {
            Tag tag = questionTag.getTag();
            if (tag == null) {
                return null;
            } else {
                String tagWord = tag.getTagWord();
                return tagWord == null ? null : tagWord;
            }
        }
    }

}
