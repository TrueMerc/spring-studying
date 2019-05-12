package ru.ryabtsev.spring;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="_students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String lastName;

    @OneToMany(mappedBy = "student_id")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Course> courses;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Student() {

    }

    @Override
    public String toString() {
        String result = "Student [id = " + id + "] " + lastName + " " + firstName + "\n";
//        result += "Courses: ";
//        for(Course course: courses) {
//            //result +=
//        }
        return result;
    }
}
