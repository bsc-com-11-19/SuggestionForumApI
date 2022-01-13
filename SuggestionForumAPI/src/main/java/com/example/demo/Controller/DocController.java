package com.example.demo.Controller;

import com.example.demo.Service.DocStorageService;
import com.example.demo.model.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController

public class DocController {
    @Autowired
    private DocStorageService docStorageService;
    @GetMapping("/")
    public String get(Model model){
        List<Doc> docs=docStorageService.getFiles();
        model.addAttribute("docs",docs);
        return "docs";
    }
    @RequestMapping("/upload")
    @PostMapping("/")
    public String UploadMultipleFiles(@RequestParam("file") MultipartFile[] files){
    for(MultipartFile file:files){
        docStorageService.saveFile(file);
    }
    return "Redirect:/";

    }
    @RequestMapping("download")
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource>downloadFile(@PathVariable Integer fileId){
        Doc doc=docStorageService.getFile(fileId).get();
        return ResponseEntity.ok().
                contentType(MediaType.parseMediaType(doc.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:fileName=\""+doc.getDocName()+"\"")
                .body(new ByteArrayResource(doc.getData()));
    }

}
