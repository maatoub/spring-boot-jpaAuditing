package com.projet.uploadfile.services;

import org.springframework.core.io.Resource;

import com.projet.uploadfile.entities.Student;

public interface IStudentService {
    Student SaveStudent(Student student);
    
    Resource loadFile(String fileName);
}
