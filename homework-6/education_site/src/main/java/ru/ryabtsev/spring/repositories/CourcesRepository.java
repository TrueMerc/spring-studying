package ru.ryabtsev.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ryabtsev.spring.entities.Course;

public interface CourcesRepository extends CrudRepository<Course, Long> {}
