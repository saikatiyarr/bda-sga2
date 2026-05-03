package com.example.studentcourse.repository;

import org.springframework.data.jpa.repository.*;
import com.example.studentcourse.model.Course;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("SELECT c FROM Course c JOIN c.student s")
    List<Course> getCoursesWithStudents();
    List<Course> findByTitle(String title);
}