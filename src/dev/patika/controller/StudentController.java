package dev.patika.controller;

import dev.patika.models.Course;
import dev.patika.models.Student;
import dev.patika.service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService = new StudentService();

    public Student findStudent(int id){
        return studentService.findById(id);
    }

    public List<Student> findAllStudent(){
        return studentService.findAll();
    }

    public void saveStudent(Student student){

        studentService.saveToDatabase(student);
    }

    public List<Course> findCoursesofStudent(long id){
        return null;
    }

}
