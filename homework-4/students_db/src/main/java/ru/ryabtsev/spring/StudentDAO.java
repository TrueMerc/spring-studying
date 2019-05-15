package ru.ryabtsev.spring;

public interface StudentDAO {
    void insert(Student disk);

    String findTitleById(Long id);
}
