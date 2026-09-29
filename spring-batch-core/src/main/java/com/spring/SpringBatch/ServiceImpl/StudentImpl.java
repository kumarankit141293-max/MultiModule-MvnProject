package com.spring.SpringBatch.ServiceImpl;

import com.spring.SpringBatch.Models.Student;
import com.spring.SpringBatch.Repository.StudentRepo;
import com.spring.SpringBatch.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentImpl implements StudentService {

    private final StudentRepo studentRepo;

    //ye constructor injection hai, isse hum StudentRepo ko inject kar rahe hai. iska fayda ye hai ki hum StudentRepo ke methods ko use kar sakte hai.
    @Autowired
    public StudentImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Page<Student> studentList(Pageable pageable){
        return studentRepo.findAll(pageable);
    }
}
