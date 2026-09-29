package com.spring.SpringBatch.ServiceImpl;

import com.spring.SpringBatch.Models.Student;
import com.spring.SpringBatch.Repository.StudentRepo;
import com.spring.SpringBatch.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {

    private final StudentRepo studentRepo;

    //ye constructor injection hai, isse hum StudentRepo ko inject kar rahe hai. iska fayda ye hai ki hum StudentRepo ke methods ko use kar sakte hai.
    @Autowired
    public StudentImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> studentList(){
        return studentRepo.findAll();
    }
}
