package com.projet.uploadfile.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projet.uploadfile.entities.Student;
import com.projet.uploadfile.services.IStudentService;

import lombok.AllArgsConstructor;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private IStudentService service;

    @PostMapping("/save")
    public Student postMethodName(
            @RequestParam("file") MultipartFile file,
            @RequestParam("username") String username,
            @RequestParam("email") String email) {
        String filePath = "/uploads/" + file.getOriginalFilename();
        Student student = Student.builder()
                .email(email).username(username)
                .file(filePath).build();
        return service.SaveStudent(student);
    }

    @GetMapping("/file/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        Resource file = service.loadFile(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(file);
    }
}