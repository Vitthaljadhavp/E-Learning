package com.BE.learning.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    private final Path rootLocation = Paths.get("uploaded_files");

    public String storeFile(MultipartFile file) {
        try {
            // Ensure the file is stored using the correct Path object
            Path targetLocation = this.rootLocation.resolve(Paths.get(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return file.getOriginalFilename();
        } catch (IOException e) {
            throw new RuntimeException("Could not store file " + file.getOriginalFilename(), e);
        }
    }
}
