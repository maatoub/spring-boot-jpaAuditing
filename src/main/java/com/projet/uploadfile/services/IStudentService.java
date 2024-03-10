package com.projet.uploadfile.services;

import org.springframework.core.io.Resource;

import com.projet.uploadfile.entities.Student;

import java.util.List;

public interface IStudentService {
    Student saveStudent(Student student);
    Student updateStudent(Student student);
    List<Student> allStudent();
}