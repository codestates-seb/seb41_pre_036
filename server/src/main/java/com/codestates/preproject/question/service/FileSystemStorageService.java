package com.codestates.preproject.question.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class FileSystemStorageService implements StorageService{
    @Override
    public void store(MultipartFile file) {

    }
}
