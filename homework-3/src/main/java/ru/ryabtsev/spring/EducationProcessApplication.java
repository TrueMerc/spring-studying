package ru.ryabtsev.spring;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Implements main application of the third homework of 'Spring Studying' course.
 */
public class EducationProcessApplication
{
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(EducationProcess.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        session.beginTransaction();

        session.getTransaction().commit();

    }
}
