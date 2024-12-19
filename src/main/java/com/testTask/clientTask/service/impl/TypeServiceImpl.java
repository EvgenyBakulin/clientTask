package com.testTask.clientTask.service.impl;

import com.testTask.clientTask.dto.TypeDTO;
import com.testTask.clientTask.dto.TypeToSaveDTO;
import com.testTask.clientTask.dto.mapper.TypeMapper;
import com.testTask.clientTask.exception.EmptyValueException;
import com.testTask.clientTask.exception.NotFoundException;
import com.testTask.clientTask.model.TypeEntity;
import com.testTask.clientTask.repository.TypeRepository;
import com.testTask.clientTask.service.TypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;

    public TypeServiceImpl(TypeRepository typeRepository, TypeMapper typeMapper) {
        this.typeRepository = typeRepository;
        this.typeMapper = typeMapper;
    }

    @Override
    public TypeDTO addType(TypeToSaveDTO info) {
        if(info.getName().isEmpty())
            throw new EmptyValueException("Название типа не должно быть пустым полем!");
        TypeEntity type = new TypeEntity();
        type.setName(info.getName());
        return typeMapper.toDTO(typeRepository.save(type));
    }

    @Override
    public TypeDTO getById(Integer id) {
        return typeMapper.toDTO(typeRepository.findById(id).orElseThrow(()->new NotFoundException("Тип не найден!")));
    }

    @Override
    public TypeDTO update(Integer id, TypeToSaveDTO info) {
        if(info.getName().isEmpty())
            throw new EmptyValueException("Название типа не должно быть пустым полем!");
        TypeEntity type = typeRepository.findById(id).orElseThrow(()->new NotFoundException("Тип не найден!"));
        type.setName(info.getName());
        return typeMapper.toDTO(typeRepository.save(type));
    }

    @Override
    public List<TypeDTO> getAll() {
        return typeRepository.findAll().stream().map(typeMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        TypeEntity type = typeRepository.findById(id).orElseThrow(()->new NotFoundException("Тип не найден!"));
        typeRepository.delete(type);
    }
}
