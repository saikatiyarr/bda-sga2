package com.example.studentcourse;
import com.example.studentcourse.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

public class CourseRepositoryTest {

    @Test
    void testRepoNotNull() {
        CourseRepository repo = Mockito.mock(CourseRepository.class);
        assertNotNull(repo);
    }
}