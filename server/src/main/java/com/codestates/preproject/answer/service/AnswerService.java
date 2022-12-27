package com.codestates.preproject.answer.service;

import com.codestates.preproject.answer.dto.response.AnswerResponseDto;
import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.answer.repository.AnswerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository){
        this.answerRepository = answerRepository;
    }

    public AnswerEntity createAnswer(AnswerEntity answerEntity) {
        return answerRepository.save(answerEntity);
    }

    public AnswerEntity updateAnswer(AnswerEntity answerEntity){
        AnswerEntity findAnswer = findVerifiedAnswer(answerEntity.getAnswer_id());

        Optional.ofNullable(answerEntity.getAnswer_id())
                .ifPresent(answer_id ->findAnswer.setAnswer_id(answer_id));
        Optional.ofNullable(answerEntity.getAnswer_content())
                .ifPresent(answer_content -> findAnswer.setAnswer_content(answer_content));
        return answerRepository.save(findAnswer);
    }

    public void deleteAnswer(long answer_id){
        AnswerEntity findAnswer = findVerifiedAnswer(answer_id);
        answerRepository.delete(findAnswer);
    }
    public AnswerEntity findAnswer(long answer_id){
        return findVerifiedAnswer(answer_id);
    }

    public List<AnswerEntity> findAnswers() {
        return answerRepository.findAll();
    }

@Transactional(readOnly = true)
    private AnswerEntity findVerifiedAnswer(long answer_id) {
        Optional<AnswerEntity> optionalAnswerEntity = answerRepository.findById(answer_id);
        AnswerEntity findAnswer =
                optionalAnswerEntity.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No answers found."));
        return findAnswer;
    }
}
