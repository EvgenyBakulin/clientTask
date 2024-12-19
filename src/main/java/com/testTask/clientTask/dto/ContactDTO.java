package com.testTask.clientTask.dto;

import java.util.Objects;

public class ContactDTO {
    private Long id;
    private ClientDTO client;
    private String value;
    private TypeDTO type;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClientDTO getClient() {
        return client;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactDTO that = (ContactDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(value, that.value) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, value, type);
    }

    @Override
    public String toString() {
        return "ContactDTO{" +
                "client=" + client +
                ", id=" + id +
                ", value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
