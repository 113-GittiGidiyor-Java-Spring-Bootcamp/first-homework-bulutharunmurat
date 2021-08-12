package dev.patika.service;

import dev.patika.models.Student;
import dev.patika.repository.CrudRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentService implements CrudRepository<Student> {

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

    @Override
    public void updateOnDatabase(Student object, int id) {

    }
}

