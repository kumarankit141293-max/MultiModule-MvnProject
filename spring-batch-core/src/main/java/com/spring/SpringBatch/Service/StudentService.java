package com.spring.SpringBatch.Service;

import com.spring.SpringBatch.Models.Student;

import java.util.List;

public interface StudentService {
    //Dont make this method private because we want to access it from the controller
     List<Student> studentList();

}
