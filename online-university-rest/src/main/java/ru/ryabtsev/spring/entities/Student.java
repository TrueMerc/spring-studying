package ru.ryabtsev.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="_students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    @Column(name = "registration_date_time")
    private Timestamp timestamp;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="employee_id")
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "_students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @Cascade({org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.DETACH})
    private List<Course> courses;

    public Student() {}

    @Override
    public String toString() {
        String result = "Student [id = " + id + "] " + lastName + " " + firstName + "\nCourses list:\n";
        for(Course course : courses) {
            result += course;
        }
        return result;
    }
}
