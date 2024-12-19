package com.testTask.clientTask.dto.mapper;

import com.testTask.clientTask.dto.ClientDTO;
import com.testTask.clientTask.dto.TypeDTO;
import com.testTask.clientTask.model.ClientEntity;
import com.testTask.clientTask.model.TypeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TypeMapper {
    TypeDTO toDTO(TypeEntity entity);
}
