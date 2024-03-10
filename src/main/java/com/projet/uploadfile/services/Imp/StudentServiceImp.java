package com.projet.uploadfile.services.Imp;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.projet.uploadfile.entities.Student;
import com.projet.uploadfile.repository.StudentRepo;
import com.projet.uploadfile.services.IStudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImp implements IStudentService {

    private StudentRepo repository;

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        student.setId(student.getId());
        return repository.save(student);
    }

    @Override
    public List<Student> allStudent() {
        return repository.findAll();
    }
}