package com.codestates.preproject.question.service;

import com.codestates.preproject.question.dto.QuestionTagDto;
import com.codestates.preproject.tag.repository.TagRepository;
import com.codestates.preproject.tag.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionTagService {
    private final QuestionService questionService;
    private final TagService tagService;

    public QuestionTagService(QuestionService questionService, TagService tagService) {
        this.questionService = questionService;
        this.tagService = tagService;
    }
}
