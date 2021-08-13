package dev.patika.clients;

import dev.patika.controller.*;
import dev.patika.models.*;
import dev.patika.models.*;
import dev.patika.utils.*;

import javax.persistence.EntityManager;
import javax.xml.transform.sax.SAXResult;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class SchoolManagementApiClient {
    public static void main(String[] args) {
        saveTestData();
        StudentController controller = new StudentController();
        //Student student4 = new Student("messi", "Istanbul",
                //LocalDate.of(2021, Month.AUGUST,12), 'M');

        //controller.saveStudent(student4);
        //controller.deleteStudent(2);
        List<Student> returnedList = new StudentController().findAllStudent();

        for (Student student : returnedList) {
            System.out.println(student);
        }
    }

    private static void saveTestData() {

        Student student1 = new Student("Harun Murat Bulut", "Istanbul",
                LocalDate.of(1994, Month.MAY,04), "Male");
        Student student2 = new Student("Dilara Demir", "Istanbul",
                LocalDate.of(2000, Month.AUGUST,12), "Female");
        Student student3 = new Student("Tolga", "Istanbul",
                LocalDate.of(2001, Month.AUGUST,18), "Male");

        Instructor pi1 = new PermanentInstructor("Veli", "Ankara",
                "05552022222", 3000.0F);
        Instructor pi2 = new PermanentInstructor("Mehmet Demir", "Bursa",
                "05524456632", 2525.0F);


        Instructor vr1 = new VisitingResearcher("Cenk", "İzmir",
                "05524456632", 4000.0F);

        Course c1 = new Course("CALCULUS", "MAT101", 5.0F);
        Course c2 = new Course("INTRODUCTION TO COMPUTER SCIENCE", "CS101", 4.0F);

        c1.setInstructor(pi1);
        c2.setInstructor(vr1);

        student1.getCourseList().add(c1);
        student1.getCourseList().add(c2);
        student2.getCourseList().add(c1);
        student3.getCourseList().add(c2);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(student1);
            em.persist(student2);
            em.persist(student3);
            em.persist(pi1);
            em.persist(pi2);
            em.persist(vr1);
            em.persist(c1);
            em.persist(c2);

            em.getTransaction().commit();

            System.out.println("Success database creation!");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }
}
