package com.spring.SpringBatch.Controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("/batch")
public class BatchUploadController {

    private final JobLauncher jobLauncher;
    private final Job importJob;

    public BatchUploadController(JobLauncher jobLauncher, @Qualifier("importJob") Job importJob) {
        this.jobLauncher = jobLauncher;
        this.importJob = importJob;
    }


    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        // Save file to temp location
        Path tempFile = Files.createTempFile("students-", ".csv");
        file.transferTo(tempFile.toFile());

        // Pass file path as JobParameter
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("filePath", tempFile.toString())
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();

        jobLauncher.run(importJob, jobParameters);

        return ResponseEntity.ok("Batch job started successfully!");
    }
}
