package dev.patika.controller;

import dev.patika.models.*;
import dev.patika.service.*;

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

    public void deleteFromDatabase(int id){
        studentService.deleteFromDatabase(id);
    }
    public void deleteStudent(int id){
        studentService.deleteStudentFromDatabase(id);
    }


    public List<Course> findCoursesofStudent(long id){
        return null;
    }

}
