package com.spring.SpringBatch.Controller;

import com.spring.SpringBatch.Models.Student;
import com.spring.SpringBatch.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    private final StudentService studentList;

    /* ye constructor injection hai, isse hum StudentRepo ko inject kar rahe hai.
       iska fayda ye hai ki hum StudentRepo ke methods ko use kar sakte hai.*/
    @Autowired
    public StudentController(StudentService studentList) {
        this.studentList = studentList;
    }

    @GetMapping("/StudentList")
    public Page<Student> getStudents(
            @RequestParam(defaultValue="0") int page, // Page number (0 se shuru hota hai)
            @RequestParam(defaultValue="10") int size, // Ek page par kitne records honge
            @RequestParam(defaultValue="id") String sortBy ) { // Corrected 'sośrtBy' to 'sortBy'

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending()); // Pageable object banana
        return studentList.studentList(pageable);
    }
}