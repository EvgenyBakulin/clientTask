package com.testTask.clientTask.controller;

import com.testTask.clientTask.dto.ClientDTO;
import com.testTask.clientTask.dto.ClientToSaveDTO;
import com.testTask.clientTask.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client-information")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    @Operation(summary = "Создать запись с именем и id клиента в базе данных")
    @SneakyThrows
    @PostMapping("/add")
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientToSaveDTO info) {
        return ResponseEntity.ok(clientService.addClient(info));
    }
    @Operation(summary = "Получить запись клиента по id")
    @SneakyThrows
    @GetMapping("/get/{id}")
    public ResponseEntity<ClientDTO> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClient(id));
    }
    @Operation(summary = "Получить список всех клиентов")
    @SneakyThrows
    @GetMapping("/get-all")
    public ResponseEntity<List<ClientDTO>> getList() {
        return ResponseEntity.ok(clientService.getAll());
    }
    @Operation(summary = "Изменить запись клиента по id")
    @SneakyThrows
    @PatchMapping("/update/{id}")
    public ResponseEntity<ClientDTO> updateById(@PathVariable Long id, @RequestBody ClientToSaveDTO info) {
        return ResponseEntity.ok(clientService.update(id,info));
    }
    @Operation(summary = "Удалить запись клиента по его id")
    @SneakyThrows
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}
