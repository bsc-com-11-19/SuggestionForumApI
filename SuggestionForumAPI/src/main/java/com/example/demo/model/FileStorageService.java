package com.example.demo.model;

import java.io.IOException;
import java.util.stream.Stream;

import com.example.demo.Repository.FileStorageRepository;
import com.example.demo.Service.FileDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileStorageService {

    @Autowired
    private FileStorageRepository fileStorageRepository;

    public FileDatabase store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDatabase FileDatabase = new FileDatabase(fileName, file.getContentType(), file.getBytes());

        return fileStorageRepository.save(FileDatabase);
    }

    public FileDatabase getFile(String id) {
        return fileStorageRepository.findById(id).get();
    }

    public Stream<FileDatabase> getAllFiles() {
        return fileStorageRepository.findAll().stream();
    }
}
