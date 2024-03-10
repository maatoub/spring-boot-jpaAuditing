package com.projet.uploadfile.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.uploadfile.entities.Student;

public interface StudentRepo extends JpaRepository<Student, Long> { }