package com.spring.SpringBatch.Writers;

import com.spring.SpringBatch.Models.Student;
import com.spring.SpringBatch.Repository.StudentRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class StudentItemWriter {

    @Autowired
    StudentRepo repository;

    @Bean
    public ItemWriter<Student> writer(StudentRepo repository) {
        return students -> repository.saveAll(students);
    }
}
