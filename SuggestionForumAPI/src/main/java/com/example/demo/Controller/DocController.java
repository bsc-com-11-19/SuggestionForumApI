package com.example.demo.Controller;

import com.example.demo.Service.DocStorageService;
import com.example.demo.model.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class DocController {
    @Autowired
    private DocStorageService docStorageService;
    @GetMapping("/")
    public String get(Model model){
        List<Doc> docs=docStorageService.getFiles();
        model.addAttribute("docs",docs);
        return "docs";
    }
    @PostMapping("/UploadFiles")
    public String UploadMultipleFiles(@RequestParam("files") MultipartFile[] files){
    for(MultipartFile file:files){
        docStorageService.saveFile(file);
    }
    return "Redirect:/";

    }
    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource>downloadFile(@PathVariable Integer fileId){
        Doc doc=docStorageService.getFile(fileId).get();
        return ResponseEntity.ok().
                contentType(MediaType.parseMediaType(doc.getDocType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment:fileName=\""+doc.getDocName()+"\"")
                .body(new ByteArrayResource(doc.getData()));
    }

}
