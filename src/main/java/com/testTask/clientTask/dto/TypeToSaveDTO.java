package com.testTask.clientTask.dto;

import java.util.Objects;

public class TypeToSaveDTO {
    private String name;

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
        TypeToSaveDTO that = (TypeToSaveDTO) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "TypeInfoDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
