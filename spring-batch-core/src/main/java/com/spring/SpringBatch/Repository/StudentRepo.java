package com.spring.SpringBatch.Repository;

import com.spring.SpringBatch.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {
}
