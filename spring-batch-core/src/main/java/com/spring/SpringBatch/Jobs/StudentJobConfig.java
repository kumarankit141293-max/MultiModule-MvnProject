package com.spring.SpringBatch.Jobs;

import com.spring.SpringBatch.Models.Student;
import com.spring.SpringBatch.Processors.StudentItemProcessor;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.infrastructure.item.ItemReader;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StudentJobConfig {

    @Bean
    public Job studentJob(JobRepository jobRepository,
                          PlatformTransactionManager transactionManager,
                          ItemReader<Student> reader,
                          StudentItemProcessor processor,
                          ItemWriter<Student> writer) {

        // Updated StepBuilder configuration to avoid SimpleStepBuilder deprecation warnings
        Step step = new StepBuilder("student-step", jobRepository)
                .<Student, Student>chunk(10, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();

        return new JobBuilder("student-job", jobRepository)
                .start(step)
                .build();
    }
}