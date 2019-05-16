package ru.ryabtsev.spring.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "_students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "total_mark")
    private int totalMark;

    public Student() {
        this.id = 0;
        this.totalMark = 0;
    }

    @Override
    public String toString() {
        return "Student [id = " + id + "] " + lastName + " " + firstName + " - rating: " + totalMark;
    }
}
