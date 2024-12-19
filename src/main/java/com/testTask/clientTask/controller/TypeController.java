package com.testTask.clientTask.controller;

import com.testTask.clientTask.dto.TypeDTO;
import com.testTask.clientTask.dto.TypeToSaveDTO;
import com.testTask.clientTask.service.TypeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/types")
public class TypeController {
    private final TypeService typeService;

    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }
    @Operation(summary = "Создать тип контакта - номер телефона и почта - для дальнейшей работы с эндпойнтами контактов")
    @SneakyThrows
    @PostMapping("/add")
    public ResponseEntity<TypeDTO> addClient(@RequestBody TypeToSaveDTO info) {
        return ResponseEntity.ok(typeService.addType(info));
    }
    @Operation(summary = "Получить тип контакта по id")
    @SneakyThrows
    @GetMapping("/get/{id}")
    public ResponseEntity<TypeDTO> getClient(@PathVariable Integer id) {
        return ResponseEntity.ok(typeService.getById(id));
    }
    @Operation(summary = "Получить список всех типов контактов")
    @SneakyThrows
    @GetMapping("/get-all")
    public ResponseEntity<List<TypeDTO>> getList() {
        return ResponseEntity.ok(typeService.getAll());
    }
    @Operation(summary = "Изменить наименование типа контакта по id")
    @SneakyThrows
    @PatchMapping("/update/{id}")
    public ResponseEntity<TypeDTO> updateById(@PathVariable Integer id, @RequestBody TypeToSaveDTO info) {
        return ResponseEntity.ok(typeService.update(id,info));
    }
    @Operation(summary = "Удалить тип контакта по id")
    @SneakyThrows
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        typeService.delete(id);
    }
}
