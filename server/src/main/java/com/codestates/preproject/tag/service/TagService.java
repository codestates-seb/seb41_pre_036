package com.codestates.preproject.tag.service;

import com.codestates.preproject.tag.entity.Tag;
import com.codestates.preproject.tag.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag findTag(Long tagId) {
        return findVerifiedTagById(tagId);
    }

    public Tag findVerifiedTagById(Long tagId) {
        Optional<Tag> optionalTag = tagRepository.findById(tagId);

        Tag verifiedTag = optionalTag.orElseThrow();
        return verifiedTag;
    }
}
