package com.example.taskcrudhibernate.repo.impl;

import com.example.taskcrudhibernate.model.Project;
import com.example.taskcrudhibernate.repo.ProjectRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectRepoImpl implements ProjectRepo {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(project);
    }

    @Override
    public List<Project> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from projects", Project.class).getResultList();
    }

    @Override
    public Project findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Project.class, id);
    }

    @Override
    public boolean deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Project project = session.get(Project.class, id);
        if (project != null) {
            session.remove(project);
            return true;
        } else return false;
    }
}
