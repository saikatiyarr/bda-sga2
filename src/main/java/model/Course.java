package com.example.studentcourse.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int credits;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}