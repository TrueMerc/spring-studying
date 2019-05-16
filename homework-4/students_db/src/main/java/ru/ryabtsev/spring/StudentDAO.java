package ru.ryabtsev.spring;

import ru.ryabtsev.spring.entities.Student;

public interface StudentDAO {
    void insert(Student disk);

    String findTitleById(Long id);
}
