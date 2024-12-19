package com.testTask.clientTask.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

@Entity
public class ContactEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "clientId", referencedColumnName = "id")
    private ClientEntity client;
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "typeId", referencedColumnName = "id")
    private TypeEntity type;
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public TypeEntity getType() {
        return type;
    }

    public void setType(TypeEntity type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactEntity contact = (ContactEntity) o;
        return Objects.equals(id, contact.id) && Objects.equals(client, contact.client) && Objects.equals(type, contact.type) && Objects.equals(value, contact.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, type, value);
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "client=" + client +
                ", id=" + id +
                ", type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
