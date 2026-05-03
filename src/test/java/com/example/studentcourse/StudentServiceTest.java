package com.example.studentcourse;
import com.example.studentcourse.model.Student;
import com.example.studentcourse.repository.StudentRepository;
import com.example.studentcourse.service.StudentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    void testGetAllStudents() {
        StudentRepository repo = Mockito.mock(StudentRepository.class);

        Student s1 = new Student();
        s1.setName("Rahul");

        Mockito.when(repo.findAll()).thenReturn(Arrays.asList(s1));

        StudentService service = new StudentService(repo);

        assertEquals(1, service.getAll().size());
    }
}