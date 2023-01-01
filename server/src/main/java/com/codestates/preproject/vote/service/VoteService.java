package com.codestates.preproject.vote.service;

import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.answer.service.AnswerService;
import com.codestates.preproject.member.entity.Member;
import com.codestates.preproject.member.service.MemberService;
import com.codestates.preproject.vote.Repository.VoteRepository;
import com.codestates.preproject.vote.entity.VoteEntity;
import org.springframework.stereotype.Service;

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    private final AnswerService answerService;

    private final MemberService memberService;

    public VoteService(VoteRepository voteRepository,
                       AnswerService answerService,
                       MemberService memberService) {
        this.voteRepository = voteRepository;
        this.answerService = answerService;
        this.memberService = memberService;
    }
//    private final VoteRepository voteRepository;

//    public VoteService(VoteRepository voteRepository){
//        this.voteRepository = voteRepository;
//    }

    public VoteEntity createVote(VoteEntity voteEntity) {

//        System.out.println("회원" + voteEntity.getMember_id() + "의 답변" + voteEntity.getAnswer_id() + "에 대한 투표 = " + voteEntity.getOpinion()); // 회원2의 답변 1에 대한 투표 = -1
        Member member = memberService.findMember(voteEntity.getMember_id());
//        System.out.println(member.getMember_id());
        AnswerEntity answerEntity = answerService.findAnswer(voteEntity.getAnswer_id());
//        System.out.println((answerEntity.getAnswer_id()));

        voteEntity.setAnswerEntity(voteEntity.getAnswerEntity());
        voteEntity.setMember(voteEntity.getMember());
        voteEntity.setOpinion(voteEntity.getOpinion());

//        System.out.println("회원" + voteEntity.getMember().getMember_id() + "의 답변 " + voteEntity.getAnswerEntity().getAnswer_id() + "에 대한 투표 = " + voteEntity.getOpinion());
        return voteRepository.save(voteEntity);
    }
}
