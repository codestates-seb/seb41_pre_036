package com.codestates.preproject.question.service;

import com.codestates.preproject.auth.utils.LoggedInMemberInfoUtils;
import com.codestates.preproject.exception.BusinessLogicException;
import com.codestates.preproject.exception.ExceptionCode;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.member.repository.MemberRepository;
import com.codestates.preproject.member.service.MemberService;
import com.codestates.preproject.question.entity.Question;
import com.codestates.preproject.question.repository.QuestionRepository;
import com.codestates.preproject.tag.service.TagService;
import com.codestates.preproject.utils.CustomBeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final MemberService memberService;
    private final LoggedInMemberInfoUtils loggedInMemberInfoUtils;
    private final TagService tagService;
    //    private final StorageService storageService;
    private final CustomBeanUtils<Question> beanUtils;
    private final MemberRepository memberRepository;

    public QuestionService(QuestionRepository questionRepository, MemberService memberService, LoggedInMemberInfoUtils loggedInMemberInfoUtils, TagService tagService, CustomBeanUtils<Question> beanUtils,
                           MemberRepository memberRepository) {
        this.questionRepository = questionRepository;
        this.memberService = memberService;
        this.loggedInMemberInfoUtils = loggedInMemberInfoUtils;
        this.tagService = tagService;
        this.beanUtils = beanUtils;
        this.memberRepository = memberRepository;
    }

    /*
    public Question createQuestion(Question question, MultipartFile questionImage) {
        // 이미지 정보 추가
        question.setQuestionImage(questionImage.getOriginalFilename());

        storageService.store(questionImage);
        return questionRepository.save(question);
    }
     */
    public Question createQuestion(Question question, Long member_id) {
//        System.out.println(question.getQuestionTags().get(0).getTagWord()); //todo QuestionTag{questionTagId=null, question=null, tag=null}
        // 현재 로그인한 회원이 유효한지/존재하는지 확인 + 질문의 작성자가 되도록 세팅
//        Long loggedInMemberId = loggedInMemberInfoUtils.extractMemberId();
//        String loggedInMemberEmail = loggedInMemberInfoUtils.extractUsername();
//        Member member = memberRepository.findByEmail(loggedInMemberEmail).get();
        question.setMember(loggedInMemberInfoUtils.extractMember());

//        verifyQuestion(question);
        // 태그가 존재하는지 확인 -> 존재하면 질문 관련 태그로 등록/세팅
        question.getQuestionTags().stream().forEach(questionTag -> questionTag.setTag(tagService.findVerifiedTag(questionTag.getTagId())));

        return questionRepository.save(question);
    }

    public Question updateQuestion(Question question) {
        // 본인이 작성한 글만 수정 가능
        verifyQuestionWriter(question.getQuestion_id());
//        System.out.println(question.toString());
        Question verifiedQuestion = findVerifiedQuestion(question.getQuestion_id());
//        System.out.println(verifiedQuestion);
//        System.out.println("변경 전 태그 단어 = " + verifiedQuestion.getQuestionTags().get(0).getTagWord()); // todo 변경 전 태그 단어 = JavaScript
//        Question updatedQuestion = beanUtils.copyNonNullProperties(question, verifiedQuestion);

        Optional.ofNullable(question.getQuestionTitle())
                .ifPresent(questionTitle -> verifiedQuestion.setQuestionTitle(questionTitle));
        Optional.ofNullable(question.getQuestionContent())
                .ifPresent(questionContent -> verifiedQuestion.setQuestionContent(questionContent));
//        Optional.ofNullable(question.getQuestionTags()).ifPresent(questionTags -> verifiedQuestion.setQuestionTags(question.getQuestionTags())); // 변경 후 태그 단어 = null

        Optional.ofNullable(question.getQuestionTags())
                .ifPresent(questionTags -> verifiedQuestion.setQuestionTags(questionTags));
//        System.out.println("변경 후 1번째 태그 단어 = " + verifiedQuestion.getQuestionTags().get(0).getTagWord()); // todo 변경 후 1번째 태그 단어 = Spring
//        System.out.println("변경 후 1번째 태그 번호 = " + verifiedQuestion.getQuestionTags().get(0).getTagId()); // todo 변경 후 1번째 태그 번호 = 4
        // 이상 questionTags 객체들에도 필요한 데이터 다 반영한 것 같은데..

        Question updatedQuestion = questionRepository.save(verifiedQuestion);
//        System.out.println(verifiedQuestion.toString());
//        System.out.println(updatedQuestion.toString());
//        System.out.println("변경 후 1번째 태그 번호 = " + verifiedQuestion.getQuestionTags().get(0).getTagId()); // todo 윗줄과 똑같이 접근하는데 왜 여기 getTagId()에서는 null pointer exception 발생하지?
//        System.out.println("변경 내역을 저장한 질문의 1번째 태그 번호 = " + updatedQuestion.getQuestionTags().get(0).getTagId());
        return updatedQuestion;
    }

    public Question findQuestion(Long questionId) {
        Question foundQuestion = findVerifiedQuestion(questionId);

        // '질문 작성자가 현재 글 조회하는 사람이 아니면' 조건 추가
        foundQuestion = updateViews(foundQuestion);

        return foundQuestion;
    }

    // 기능4a = 'top questions' = 메인페이지 = 질문 전체 조회 + default로 newest순으로 정렬
    public Page<Question> findQuestionsByCreatedAt(int page, int size) {
        return questionRepository.findAll(PageRequest.of(page, size, Sort.by("createdAt").descending())); // 답변 개수 순서대로 정렬하는 건 repository에서?
    }

    public Page<Question> findQuestionsByTitleOrContent(String title, String content, int page, int size) {
        return questionRepository.findByQuestionTitleContainingIgnoreCaseOrQuestionContentContainingIgnoreCase(title, content, PageRequest.of(page, size, Sort.by("views").descending()));
    }

    public void deleteQuestion(Long questionId) {
        // 본인이 작성한 글만 수정 가능
        verifyQuestionWriter(questionId);
        Question findQuestion = findVerifiedQuestion(questionId);
        questionRepository.delete(findQuestion);
    }

    public Question findVerifiedQuestion(Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        Question verifiedQuestion = optionalQuestion.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));
        return verifiedQuestion;
    }

public Question verifyQuestion(Long questionId) {
        Optional<Question> optionalQuestion = questionRepository.findById(questionId);
        return optionalQuestion.orElseThrow(() -> new BusinessLogicException(ExceptionCode.QUESTION_NOT_FOUND));

        // 질문을 작성한 회원이 유효한지/존재하는지 확인
        /*
        if (question.getMember() != null) {
            question.setMember(memberService.findMember(question.getMember_id()));
        }

        // 태그가 존재하는지 확인
        question.getQuestionTags().stream().forEach(questionTag -> questionTag.setTag(tagService.findVerifiedTag(questionTag.getTagId())));
         */
    }
    /*
    public void verifyQuestionTags(List<QuestionTag> questionTags) {
        questionTags.forEach(questionTag -> tagService.findTag(questionTag.getTag().getTagId()));
    }

    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
     */

    public Question updateViews(Question foundQuestion) {
        foundQuestion.setViews(foundQuestion.getViews() + 1);
        return questionRepository.save(foundQuestion);
    }

    public void verifyQuestionWriter(Long questionId) {
        Long loggedInMemberId = loggedInMemberInfoUtils.extractMember().getMember_id();
        Long questionWriterId = verifyQuestion(questionId).getMember_id();

        if (loggedInMemberId != questionWriterId) {
            throw new BusinessLogicException(ExceptionCode.UNAUTHORIZED_MEMBER);
        }
    }
}
