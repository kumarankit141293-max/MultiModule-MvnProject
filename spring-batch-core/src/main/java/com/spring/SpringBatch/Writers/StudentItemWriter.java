package com.spring.SpringBatch.Writers;

import com.spring.SpringBatch.Models.Student;
import jakarta.persistence.EntityManagerFactory;
//import org.springframework.batch.item.database.JpaItemWriter;
//import org.springframework.batch.item.database.builder.JpaItemWriterBuilder;
import org.springframework.batch.infrastructure.item.database.JpaItemWriter;
import org.springframework.batch.infrastructure.item.database.builder.JpaItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentItemWriter {

    @Bean
    public JpaItemWriter<Student> writer(EntityManagerFactory emf) {
        return new JpaItemWriterBuilder<Student>()
                .entityManagerFactory(emf)
                .build();
    }
}