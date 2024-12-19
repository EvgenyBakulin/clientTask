package com.testTask.clientTask.dto;

import java.util.Objects;

public class ClientContactInfoDTO {
    Long clientId;
    Integer type;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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
        ClientContactInfoDTO that = (ClientContactInfoDTO) o;
        return Objects.equals(clientId, that.clientId) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, type);
    }

    @Override
    public String toString() {
        return "ClientContactInfoDTO{" +
                "clientId=" + clientId +
                ", type=" + type +
                '}';
    }
}
