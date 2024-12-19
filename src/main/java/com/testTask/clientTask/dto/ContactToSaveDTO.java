package com.testTask.clientTask.dto;

import java.util.Objects;

public class ContactToSaveDTO {
    private Long clientId;
    private String value;
    private Integer type;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactToSaveDTO that = (ContactToSaveDTO) o;
        return Objects.equals(clientId, that.clientId) && Objects.equals(value, that.value) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, value, type);
    }

    @Override
    public String toString() {
        return "ContactToSaveDTO{" +
                "clientId=" + clientId +
                ", value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
