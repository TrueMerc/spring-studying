package ru.ryabtsev.spring;

public interface StudentDAO {
    void insert(Student disk);

    Student findTitleById(Long id);
}
