package com.example.studentcourse.service;

import org.springframework.stereotype.Service;
import com.example.studentcourse.model.Student;
import com.example.studentcourse.repository.StudentRepository;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student save(Student s) {
        return repo.save(s);
    }

    public Student getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}