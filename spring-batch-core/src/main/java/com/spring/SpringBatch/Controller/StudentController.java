package com.spring.SpringBatch.Controller;

import com.spring.SpringBatch.Models.Student;
import com.spring.SpringBatch.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentList;

    //ye constructor injection hai, isse hum StudentRepo ko inject kar rahe hai. iska fayda ye hai ki hum StudentRepo ke methods ko use kar sakte hai.
    @Autowired
    public StudentController(StudentService studentList) {
        this.studentList = studentList;
    }


    @GetMapping("/StudentList")
    public List<Student> getStudents(){
        return studentList.studentList();
    }



}
