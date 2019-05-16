package ru.ryabtsev.spring;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URL;
import java.security.ProtectionDomain;

/**
 * Implements main application of the fourth homework of 'Spring Framework' course.
 */
public class StudentsRatingApplication
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/config.xml");
        JdbcTemplateStudentDAO jdbc = context.getBean("JdbcTemplate", JdbcTemplateStudentDAO.class);
        Student student = new Student();

// Database initialization is commited.
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


        Server server = new Server(8189);

        ProtectionDomain domain = StudentsRatingApplication.class.getProtectionDomain();
        URL location = domain.getCodeSource().getLocation();

        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        webapp.setWar(location.toExternalForm());

        server.setHandler(webapp);
        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            server.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
