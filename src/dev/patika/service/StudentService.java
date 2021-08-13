package dev.patika.service;

import dev.patika.models.*;
import dev.patika.repository.StudentRepository;
import dev.patika.utils.*;
import dev.patika.repository.CrudRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {
        return em.createQuery("from Student", Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return  em.find(Student.class, id);
    }

    @Override
    public void saveToDatabase(Student object) {

        em.getTransaction().begin();

        em.persist(object);

        em.getTransaction().commit();


    }

    @Override
    public void deleteFromDatabase(Student object) {

    }

    @Override
    public void deleteFromDatabase(int id) {

    }

    public void deleteStudentFromDatabase(int id) {
        em.getTransaction().begin();

        Student student = em.createQuery("from Student s WHERE s.id =:id", Student.class).setParameter("id", id).getSingleResult();

        em.remove(student);

        em.getTransaction().commit();
    }

    @Override
    public void updateOnDatabase(Student object, int id) {

    }
}

