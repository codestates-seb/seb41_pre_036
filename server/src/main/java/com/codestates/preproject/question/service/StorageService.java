package com.codestates.preproject.question.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
    void store(MultipartFile file);
}
