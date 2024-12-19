package com.testTask.clientTask.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Objects;

@Entity
public class TypeEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "type", orphanRemoval = true)
    private List<ContactEntity> contacts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContactEntity> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactEntity> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeEntity that = (TypeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(contacts, that.contacts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, contacts);
    }

    @Override
    public String toString() {
        return "TypeEntity{" +
                "contacts=" + contacts +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
