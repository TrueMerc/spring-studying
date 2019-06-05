package ru.ryabtsev.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ryabtsev.spring.entities.Course;
import ru.ryabtsev.spring.entities.Student;
import ru.ryabtsev.spring.repositories.StudentsRepository;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    private CoursesService coursesService;

//    @Autowired
//    public void setStudentsRepository(StudentsRepository studentsRepository) {
//        this.studentsRepository = studentsRepository;
//    }

    @Autowired
    public void setCoursesService(CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    public StudentsService() {}

    public List<Student> getAllStudentsList() {
        return (List<Student>)studentsRepository.findAll();
    }

    public Student getById(Long id) { return studentsRepository.findOneById(id); }

    /**
     * Adds student into repository if it is new entity or update existing student entity.
     * @param student - student entity.
     */
    public void save(final Student student) {
        studentsRepository.save(student);
    }

    public void removeById(Long id) {
        studentsRepository.delete(id);
    }

    public List<Course> getCoursesByStudentId(Long id) {
        return studentsRepository.findOneById(id).getCourses();
    }

//    public List<Course> getMissingCoursesByStudentId(Long id) {
//        List<Course> courses = coursesService.getAllCoursesList();
//        List<Course> studentsCourses = studentsRepository.findOneById(id).getCourses();
//        courses.removeAll(studentsCourses);
//        return courses;
//    }
}
