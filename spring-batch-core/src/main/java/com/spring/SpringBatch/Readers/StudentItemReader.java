package com.spring.SpringBatch.Readers;

import com.spring.SpringBatch.Models.Student;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.infrastructure.item.database.JpaPagingItemReader;
import org.springframework.batch.infrastructure.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.infrastructure.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class StudentItemReader {

    @Bean
    public FlatFileItemReader<Student> csvReader() {
        return new FlatFileItemReaderBuilder<Student>()
                .name("studentItemReader")
                .resource(new ClassPathResource("users_100.csv"))
                .linesToSkip(1) // Header skip karega
                .delimited()
                .names("id", "name", "email", "age")
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Student>() {{
                    setTargetType(Student.class);
                }})
                .build();
    }

//    @Bean
//    public JpaPagingItemReader<Student> studentDbReader(EntityManagerFactory emf) {
//        return new JpaPagingItemReaderBuilder<Student>()
//                .name("studentDbReader")
//                .entityManagerFactory(emf)
//                // Yeh query aapki existing Student entity se data uthayegi
//                .queryString("SELECT s FROM Student s")
//                .pageSize(10)
//                .build();
//    }
}