package ru.ryabtsev.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Implements main application of the fourth homework of 'Spring Framework' course.
 */
public class StudentsRatingApplication
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        JdbcTemplateStudentDAO jdbc = context.getBean("JdbcTemplate", JdbcTemplateStudentDAO.class);
        Student student = new Student();
//        student.setFirstName("John");
//        student.setLastName("Walker");
//        student.setId(5);
//        student.setTotalMark(10);
//
//        jdbc.insert(student);

        for(Long i = 1L; i < 1000L; ++i) {
            student = jdbc.findTitleById(i);
            if(null == student) { break; }
            System.out.println(student);
        }
    }
}
