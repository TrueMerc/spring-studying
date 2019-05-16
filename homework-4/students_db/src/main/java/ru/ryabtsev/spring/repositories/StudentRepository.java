package ru.ryabtsev.spring.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ryabtsev.spring.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    Iterable<Student> findAll(Sort sort);
}
