package com.example.studentcourse.service;

import org.springframework.stereotype.Service;
import com.example.studentcourse.model.Course;
import com.example.studentcourse.repository.CourseRepository;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository repo;

    public CourseService(CourseRepository repo) {
        this.repo = repo;
    }

    public List<Course> getAll() {
        return repo.findAll();
    }

    public List<Course> getWithStudents() {
        return repo.getCoursesWithStudents();
    }

    public Course save(Course c) {
        return repo.save(c);
    }

    public Course getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}