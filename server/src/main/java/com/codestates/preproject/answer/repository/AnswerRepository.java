package com.codestates.preproject.answer.repository;


import com.codestates.preproject.answer.entity.AnswerEntity;
import com.codestates.preproject.question.entity.Question;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnswerRepository extends JpaRepository<AnswerEntity , Long> {
//    List<AnswerEntity> findAllByQuestionId(Long question_id);



}
