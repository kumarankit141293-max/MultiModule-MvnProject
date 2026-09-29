package com.spring.SpringBatch.Processors;

import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;
import com.spring.SpringBatch.Models.Student;

@Component
public class StudentItemProcessor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(Student student) {
        student.setName(student.getName().toUpperCase()); // Example transformation
        return student;
    }
}