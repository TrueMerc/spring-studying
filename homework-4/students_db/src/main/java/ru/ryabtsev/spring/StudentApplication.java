package ru.ryabtsev.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Implements main application of the fourth homework of 'Spring Framework' course.
 */
@SpringBootApplication
public class StudentApplication
{
    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

//    private static int TEST_ENTITIES_NUMBER = 20;
//    private static int DEFAULT_PORT = 8189;
//
//    public static void main( String[] args )
//    {
//        Server server = new Server( DEFAULT_PORT );
//        ProtectionDomain domain = StudentApplication.class.getProtectionDomain();
//        URL location = domain.getCodeSource().getLocation();
//        WebAppContext webapp = new WebAppContext();
//        webapp.setContextPath("/");
//        webapp.setWar(location.toExternalForm());
//        server.setHandler(webapp);
//        try {
//            server.start();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            server.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
//        JdbcTemplateStudentDAO jdbc = context.getBean("JdbcTemplate", JdbcTemplateStudentDAO.class);
//
//        Student student = new Student();
//
//        for(int i = 0; i < TEST_ENTITIES_NUMBER; ++i) {
//            student.setFirstName("TestFirstName" + i);
//            student.setLastName("TestLastName" + i);
//            student.setTotalMark(1 + i);
//            jdbc.insert(student);
//        }
//    }
}
