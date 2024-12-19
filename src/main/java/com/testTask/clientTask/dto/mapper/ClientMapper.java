package com.testTask.clientTask.dto.mapper;

import com.testTask.clientTask.dto.ClientDTO;
import com.testTask.clientTask.model.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDTO(ClientEntity entity);
}
