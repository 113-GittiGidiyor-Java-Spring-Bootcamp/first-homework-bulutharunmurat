package dev.patika.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private Float creditScore;

    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList = new ArrayList<>();

    @ManyToOne
    private Instructor instructor;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Course(String name, String code, Float creditScore) {
        this.name = name;
        this.code = code;
        this.creditScore = creditScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Float creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(code, course.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", creditScore=" + creditScore +
                '}';
    }
}
