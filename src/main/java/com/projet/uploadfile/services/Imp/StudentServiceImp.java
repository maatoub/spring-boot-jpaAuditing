package com.projet.uploadfile.services.Imp;

import java.nio.file.Path;
import java.nio.file.Paths;

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

    private final ResourceLoader resourceLoader;
    private StudentRepo repository;

    @Override
    public Student SaveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Resource loadFile(String fileName) {
        try {      
            Path filePath = Paths.get("/uploads/", fileName);
            Resource resource = resourceLoader.getResource("file:" + filePath.toString());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                   throw new RuntimeException("Le fichier n'a pas pu être trouvé : " + fileName);
            }
        } catch (Exception e) {   
            throw new RuntimeException("Une erreur s'est produite lors du chargement du fichier : " + fileName, e);
        }
    }

}
