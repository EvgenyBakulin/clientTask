package com.testTask.clientTask.dto;

import java.util.Objects;

public class TypeDTO {
    private Integer id;
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeDTO typeDTO = (TypeDTO) o;
        return Objects.equals(id, typeDTO.id) && Objects.equals(name, typeDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "TypeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
