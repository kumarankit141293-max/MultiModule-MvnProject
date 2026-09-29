package com.spring.SpringBatch.Service;

import com.spring.SpringBatch.Models.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    //Dont make this method private because we want to access it from the controller
    Page<Student> studentList(Pageable pageable);
}
