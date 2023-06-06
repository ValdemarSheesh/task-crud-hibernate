package com.example.taskcrudhibernate.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity(name = "specialties")
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)

    private Long id;

    private String nameSpecialty;

    @OneToMany(mappedBy = "specialty", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private List<Employee> employees;

    public Specialty(Long id, String nameSpecialty, List<Employee> employees) {
        this.id = id;
        this.nameSpecialty = nameSpecialty;
        this.employees = employees;
    }

    public Specialty() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSpecialty() {
        return nameSpecialty;
    }

    public void setNameSpecialty(String nameSpecialty) {
        this.nameSpecialty = nameSpecialty;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
