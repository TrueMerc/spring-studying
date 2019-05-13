package ru.ryabtsev.spring;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Implements main application of the third homework of 'Spring Studying' course.
 */
public class EducationProcessApplication
{
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            List<Student> students = session.createQuery("from Student").getResultList();
            //List<Course> courses = session.createQuery("from Course").getResultList();
            for(Student student : students) {
                System.out.println(student);
            }
            session.getTransaction().commit();




        }
        finally {
            factory.close();
            session.close();
        }

    }
}
