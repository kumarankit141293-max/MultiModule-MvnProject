//package com.spring.SpringBatch.Controller;
//
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.launch.*;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//@RestController
//@RequestMapping("/api/batch")
//public class BatchUploadController {
//
//    private final JobOperator jobOperator;
//
//    public BatchUploadController(JobOperator jobOperator) {
//        this.jobOperator = jobOperator;
//    }
//
//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
//        try {
//            Path path = Paths.get("./uploads/" + file.getOriginalFilename());
//            Files.createDirectories(path.getParent());
//            Files.write(path, file.getBytes());
//
//            Long executionId = jobOperator.start("studentJob","fullPathFileName=" + path.toAbsolutePath() + ",time=" + System.currentTimeMillis());
//
//            return ResponseEntity.ok("Job started with executionId: " + executionId);
//
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError().body("Error: " + e.getMessage());
//        }
//    }
//}
//
