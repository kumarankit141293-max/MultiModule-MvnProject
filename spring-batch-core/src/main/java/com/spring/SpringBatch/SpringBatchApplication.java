package com.spring.SpringBatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}

}













//@SpringBootApplication
//public class SpringBatchApplication implements CommandLineRunner {
//
//	@Autowired
//	private JobLauncher jobLauncher;
//
//	@Autowired
//	private Job studentJob;
//
//	public static void main(String[] args) {
//		SpringApplication.run(SpringBatchApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		JobParameters params = new JobParametersBuilder()
//				.addLong("run.id", System.currentTimeMillis()) // unique param
//				.toJobParameters();
//
//		jobLauncher.run(studentJob, params);
//	}
//}

