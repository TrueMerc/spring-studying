package ru.ryabtsev.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import ru.ryabtsev.spring.entities.Student;
import ru.ryabtsev.spring.repositories.StudentRepository;

import java.util.List;

public class StudentService {
    StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "Category"));
        List<Student> students = (List<Student>) studentRepository.findAll(sort);
        System.out.println(students);
        return students;
    }
}
