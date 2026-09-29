package com.spring.SpringBatch.Jobs;

import com.spring.SpringBatch.Models.Student;
import com.spring.SpringBatch.Processors.StudentItemProcessor;
import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
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

    /*    Spring Batch job jab run hoti hai, toh uski saari history/metadata
         (jaise job kab start hui, kitna time laga, kitne steps complete hue,
         job pass hui ya fail, aur kaunsa chunk successfully execute hua) ko
         database mein save karne ka kaam JobRepository karta hai.
         job execution status, step execution status, aur job parameters ko manage karte hai.
        agar job kisi error ya failure me fail ho jata hai to ye automatically rollback kar dete hai.
         Aapne code mein .chunk(10, transactionManager) likha hai. iska matlab hai ki Spring Batch
        10-10 records ka ek batch (chunk) banakar process karega. Jaise hi 10 records successfully read,
        process aur write ho jayenge, transactionManager database mein us transaction ko commit
        kar dega (matlab save kar dega).   Rollback in Case of Error (Safety):Agar 10 records ke us chunk
        mein 7th ya 8th record par koi error ya exception aa jati hai, toh transactionManager pichle saare records
        (jo us chunk ke andar the) ko rollback kar dega. Isse adha-adhura ya galat data database mein save nahi hota,
        data ki integrity bani rehti hai.Automatic Dependency Injection:Aapko isko manually create karne ki zaroorat
        nahi padti. Spring Boot ka auto-configuration (spring-boot-starter-batch aur spring-boot-starter-data-jpa ke through)
        khud-ba-khud ek default transaction manager (jaise JpaTransactionManager ya DataSourceTransactionManager)*/
//        ko background mein bana kar yahan inject kar deta hai.