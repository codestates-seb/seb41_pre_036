package com.codestates.preproject.question.service;

import com.codestates.preproject.member.service.MemberService;
import com.codestates.preproject.question.entity.Question;
import com.codestates.preproject.question.entity.QuestionTag;
import com.codestates.preproject.question.repository.QuestionRepository;
import com.codestates.preproject.tag.entity.Tag;
import com.codestates.preproject.tag.service.TagService;
import com.codestates.preproject.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final MemberService memberService;
    private final TagService tagService;
    //    private final StorageService storageService;
    private final CustomBeanUtils<Question> beanUtils;

    public QuestionService(QuestionRepository questionRepository, MemberService memberService, TagService tagService, CustomBeanUtils<Question> beanUtils) {
        this.questionRepository = questionRepository;
        this.memberService = memberService;
        this.tagService = tagService;
        this.beanUtils = beanUtils;
    }

    /*
    public Question createQuestion(Question question, MultipartFile questionImage) {
        // 이미지 정보 추가
        question.setQuestionImage(questionImage.getOriginalFilename());

        storageService.store(questionImage);
        return questionRepository.save(question);
    }
     */

    public Question createQuestion(Question question, Long memberId) {
        question.setMember(memberService.findMember(memberId));
//        question.setQuestionTags(question.getQuestionTags());
//        question.setQuestionTags(question.);
//        System.out.println(question.getTags().get(0).toString()); // QuestionTag{questionTagId=null, question=null, tag=null}
//        System.out.println("questionTags의 첫번째 요소 = " + question.getQuestionTags().get(0).getTagId());
        verifyQuestionTags(question.getQuestionTags());

        List<QuestionTag> questionTags = question.getQuestionTags().stream().map(questionTag -> {
//            question.addQuestionTag(questionTag);
            questionTag.setQuestion(question);
            questionTag.setTag(tagService.findTag(questionTag.getTag().getTagId()));
//            for (QuestionTag qt : question.getQuestionTags()) {
//                questionTag.setTag(tagService.findTag(qt.getTagId()));
//            }
//            questionTag.setTag(tagService.findTag(question.getTag().getTagId()));
            return questionTag;
        }).collect(Collectors.toList());
        question.setQuestionTags(questionTags);

        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {
        Question verifiedQuestion = findVerifiedQuestion(question.getQuestionId());
//        System.out.println(verifiedQuestion); // todo
        Question updatedQuestion = beanUtils.copyNonNullProperties(question, verifiedQuestion);
//        System.out.println(updatedQuestion); // todo
        return questionRepository.save(updatedQuestion);
    }

    public Question findQuestion(Long questionId) {
        return findVerifiedQuestion(questionId);
    }

    public Page<Question> findQuestions(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size)); // 답변 개수 순서대로 정렬하는 건 repository에서?
    }

    public void deleteQuestion(Long questionId) {
        Question findQuestion = findVerifiedQuestion(questionId);
        questionRepository.delete(findQuestion);
    }

    public Question findVerifiedQuestion(Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question verifiedQuestion = optionalQuestion.orElseThrow();

        return verifiedQuestion;
    }

    public void verifyQuestionTags(List<QuestionTag> questionTags) {
        questionTags.forEach(questionTag -> tagService.findTag(questionTag.getTag().getTagId()));
    }
}
