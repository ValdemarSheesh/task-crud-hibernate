package com.example.taskcrudhibernate.repo.impl;

import com.example.taskcrudhibernate.model.Specialty;
import com.example.taskcrudhibernate.repo.SpecialtyRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SpecialtyRepoImpl implements SpecialtyRepo {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Specialty specialty) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(specialty);
    }

    @Override
    public List<Specialty> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from specialties", Specialty.class).getResultList();
    }

    @Override
    public Specialty findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Specialty.class, id);
    }

    @Override
    public boolean deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Specialty specialty = session.get(Specialty.class, id);
        if (specialty != null) {
            session.remove(specialty);
            return true;
        } else return false;
    }
}
