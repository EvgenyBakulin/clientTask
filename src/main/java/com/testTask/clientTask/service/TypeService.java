package com.testTask.clientTask.service;

import com.testTask.clientTask.dto.TypeDTO;
import com.testTask.clientTask.dto.TypeToSaveDTO;

import java.util.List;

public interface TypeService {
    TypeDTO addType(TypeToSaveDTO info);
    TypeDTO getById(Integer id);
    TypeDTO update(Integer id, TypeToSaveDTO info );
    List<TypeDTO> getAll();
    void delete(Integer id);
}
