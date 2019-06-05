package ru.ryabtsev.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ryabtsev.spring.entities.Student;
import ru.ryabtsev.spring.services.StudentsService;
import ru.ryabtsev.spring.services.UserService;

import java.security.Principal;
import java.util.List;

@RequestMapping("/api/**")
@RestController
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private UserService userService;

    @GetMapping("/students")
    public List<Student> getAllStudentsList() {
        return studentsService.getAllStudentsList();
    }

    @CrossOrigin
    @GetMapping
    public Student getStudentById(@PathVariable Long id) {
        return studentsService.getById(id);
    }

    @PostMapping(path="/students")
    public Student addStudent(@RequestBody final Student student, final Principal principal) {
        student.setId(0L);
        student.setUser(userService.findByUserName(principal.getName()));
        studentsService.save(student);
        return student;
    }

    @PutMapping(value = "/students", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Student updateStudent(@RequestBody final Student student) {
        studentsService.save(student);
        return student;
    }


    @RequestMapping(path="/remove/{id}", method=RequestMethod.GET)
    public String removeById(@PathVariable(value = "id") Long studentId) {
        studentsService.removeById(studentId);
        return "redirect:/students/list";
    }

    @RequestMapping(path="/courses/{id}", method=RequestMethod.GET)
    public String showStudentsCoursesInfo(Model model, @PathVariable(value = "id") Long studentId) {
        model.addAttribute("studentCourses", studentsService.getCoursesByStudentId(studentId));
//        model.addAttribute("studentMissingCourses", studentsService.getMissingCoursesByStudentId(studentId));
        return "student-courses-list";
    }
}
