package ru.ryabtsev.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.ryabtsev.spring.entities.Student;
import ru.ryabtsev.spring.entities.User;
import ru.ryabtsev.spring.registration.StudentRegistrationForm;
import ru.ryabtsev.spring.registration.UserRegistrationForm;
import ru.ryabtsev.spring.services.StudentsService;
import ru.ryabtsev.spring.services.UserService;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/students")
@Transactional
public class StudentsController {
    private StudentsService studentsService;
    private UserService userService;

    @Autowired
    public void setStudentsService(final StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @Autowired
    public void setUserService(final UserService userService) { this.userService = userService; }

    @RequestMapping("/list")
    public String showStudentsList(Model model) {
        List<Student> allStudents = studentsService.getAllStudentsList();
        model.addAttribute("studentsList", allStudents);
        return "students-list";
    }

    @RequestMapping(path="/addStudent", method= RequestMethod.GET)
    public String showAddForm(Model model) {
        StudentRegistrationForm registrationForm = new StudentRegistrationForm();
        model.addAttribute("studentRegistrationForm", registrationForm);
        return "add-student-form";
    }

    @PostMapping("/processStudentForm")
    public String processAdditionForm(
            @Valid @ModelAttribute("studentRegistrationForm") StudentRegistrationForm form,
            BindingResult bindingResult,
            Model model,
            Principal principal
    ) {
        if (bindingResult.hasErrors()) {
            return "add-student-form";
        }

        Student student = new Student(form, userService.findByUserName(principal.getName()), new Date());
        studentsService.addStudent(student);
        return "redirect:/students/list";
    }


    @RequestMapping(path="/remove/{id}", method=RequestMethod.GET)
    public String removeById(@PathVariable(value = "id") Long studentId) {
        studentsService.removeById(studentId);
        return "redirect:/students/list";
    }

    @RequestMapping(path="/courses/{id}", method=RequestMethod.GET)
    public String showStudentsCoursesInfo(Model model, @PathVariable(value = "id") Long studentId) {
        model.addAttribute("studentCourses", studentsService.getCoursesByStudentId(studentId));
        model.addAttribute("studentMissingCourses", studentsService.getMissingCoursesByStudentId(studentId));
        return "student-courses-list";
    }
}
