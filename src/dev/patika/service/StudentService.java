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

        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }


    }

    @Override
    public void deleteFromDatabase(Student object) {
        try {
            em.getTransaction().begin();
            Student foundStudent = em.createQuery("from Student s WHERE s.id =:id", Student.class).setParameter
                    ("id", object.getId()).getSingleResult();
            em.remove(foundStudent);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDatabase(int id) {
        try {
            em.getTransaction().begin();

            Student foundStudent = em.find(Student.class, id);
            em.remove(foundStudent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }

    public void deleteStudentFromDatabase(int id) {
        em.getTransaction().begin();

        Student student = em.createQuery("from Student s WHERE s.id =:id", Student.class).setParameter("id", id).getSingleResult();

        em.remove(student);

        em.getTransaction().commit();
    }

    @Override
    public void updateOnDatabase(Student object, int id) {
        try {
            em.getTransaction().begin();

            Student foundStudent = em.find(Student.class, id);
            foundStudent.setName(object.getName());
            foundStudent.setAddress(object.getAddress());
            foundStudent.setBirthDate(object.getBirthDate());
            foundStudent.setGender(object.getGender());
            em.merge(foundStudent);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public List<Course> findCoursesofStudent(int id) {
        return findStudentById(id).getCourseList();
    }

    public Student findStudentById(int id){
        return em.createQuery("from Student s where s.id=:id", Student.class).setParameter("id", id).getSingleResult();
    }
}

