package com.example.studentcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.studentcourse.model.Student;
import com.example.studentcourse.service.StudentService;

@Controller
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public String list(Model model) {
        model.addAttribute("students", service.getAll());
        return "student-list";
    }

    @GetMapping("/add-student")
    public String form(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/save-student")
    public String save(@ModelAttribute Student student) {
        service.save(student);
        return "redirect:/students";
    }

    @GetMapping("/edit-student/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("student", service.getById(id));
        return "update-student";
    }

    @PostMapping("/save-student")
    public String save(@ModelAttribute Student student) {
        try {
            service.save(student);
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/students";
    }   
}

