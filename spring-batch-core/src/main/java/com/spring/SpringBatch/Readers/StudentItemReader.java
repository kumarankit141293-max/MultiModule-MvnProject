package com.spring.SpringBatch.Readers;
//import com.spring.SpringBatch.models.Student;
import com.spring.SpringBatch.Models.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class StudentItemReader {

    @Bean
    @StepScope
    public FlatFileItemReader<Student> reader(@Value("#{jobParameters['filePath']}") String filePath) {
        return new FlatFileItemReaderBuilder<Student>()
                .name("studentItemReader")
                .resource(new FileSystemResource(filePath))
                .delimited()
                .names("name", "email", "age")
                .targetType(Student.class)
                .linesToSkip(1)   // ✅ Skip header row
                .build();
    }
}
