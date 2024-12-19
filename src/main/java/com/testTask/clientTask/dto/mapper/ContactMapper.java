package com.testTask.clientTask.dto.mapper;

import com.testTask.clientTask.dto.ClientDTO;
import com.testTask.clientTask.dto.ContactDTO;
import com.testTask.clientTask.dto.ContactShortDTO;
import com.testTask.clientTask.model.ClientEntity;
import com.testTask.clientTask.model.ContactEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TypeMapper.class, ClientMapper.class})
public interface ContactMapper {
    ContactDTO toDTO(ContactEntity entity);
    ContactShortDTO toShortDTO(ContactEntity entity);
}
