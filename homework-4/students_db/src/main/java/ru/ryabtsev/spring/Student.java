package ru.ryabtsev.spring;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int totalMark;


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

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "Student [id = " + id + "] " + lastName + " " + firstName + " - rating: " + totalMark;
    }
}
