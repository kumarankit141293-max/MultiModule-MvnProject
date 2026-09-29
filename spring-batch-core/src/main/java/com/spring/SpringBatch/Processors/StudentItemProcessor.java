package com.spring.SpringBatch.Processors;

import org.springframework.batch.infrastructure.item.ItemProcessor;
import org.springframework.stereotype.Component;
import com.spring.SpringBatch.Models.Student;

@Component
public class StudentItemProcessor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(Student student) {
        student.setName(student.getName().toUpperCase()); // Example transformation
        return student;
    }
}

/*

Toh Spring Batch internaly ek pipeline ya loop chala deta hai. Yeh loop background mein kuch is tarah kaam karta hai:

    Reader se data lena: Spring Batch khud reader.read() method ko call karta hai. Yeh method ek baar mein ek single Student object (CSV file se read karke) return karta hai.

    Processor ko dena: Jaise hi Reader ek Student object laakar deta hai, Spring Batch turant us object ko uthata hai aur processor.process(student) method ke andar parameter ke roop mein pass kar deta hai.

    Aapka logic chalna: Aapke StudentItemProcessor class ka process method us student object ko receive karta hai (Student student), uspe apna logic chalata hai (jaise setName karke uppercase karna), aur wapas updated student object return kar deta hai.

    Writer ko bhejna: Processor se jo updated object nikalta hai, Spring Batch use ek list mein jama karta rehta hai jab tak chunk size (10) poora nahi ho jata, aur fir writer.write(...) ko bhej deta hai.


Aapko code mein manually yeh nahi likhna padta ki "Reader ka data utha kar Processor ko do".
Spring Batch ka Chunk-based Step Engine khud background mein loop chલાકar Reader se ek-ek record nikalta hai,
use Processor ko deta hai, aur processor ke output ko Writer ko pass kar deta hai!
public Job studentJob(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager,
                      ItemReader<Student> reader,          // <--- Yahan inject hua
                      StudentItemProcessor processor,     // <--- Yahan inject hua
                      ItemWriter<Student> writer)         // <--- Yahan inject hua

*/
