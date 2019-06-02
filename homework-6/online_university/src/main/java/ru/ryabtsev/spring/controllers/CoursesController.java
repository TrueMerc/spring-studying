package ru.ryabtsev.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.ryabtsev.spring.entities.Course;
import ru.ryabtsev.spring.services.CoursesService;

import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping("/courses")
@Transactional
public class CoursesController {
    private CoursesService coursesService;

    @Autowired
    public void setCoursesService(final CoursesService coursesService) {
        this.coursesService = coursesService;
    }

    @RequestMapping("/list")
    @Transactional
    public String showCoursesList(final Model model) {
        List<Course> courses = coursesService.getAllCoursesList();
        model.addAttribute("coursesList", courses);
        return "courses-list";
    }
}
