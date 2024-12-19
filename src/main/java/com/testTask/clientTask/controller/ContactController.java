package com.testTask.clientTask.controller;

import com.testTask.clientTask.dto.*;
import com.testTask.clientTask.service.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    @Operation(summary = "Создать запись контакта определённого клиента, указав его id и id типа контакта")
    @SneakyThrows
    @PostMapping("/add")
    public ResponseEntity<ContactDTO> addContact(@RequestBody ContactToSaveDTO info) {
        return ResponseEntity.ok(contactService.addContact(info));
    }
    @Operation(summary = "получить все контакты клиента по id клиента и id типа контакта")
    @SneakyThrows
    @GetMapping("/get-contacts-by-type/{clientId}")
    public ResponseEntity<Map<ClientDTO, List<ContactShortDTO>>> getContacts(@PathVariable Long clientId, @RequestParam Integer type) {
        return ResponseEntity.ok(contactService.getOneTypeContacts(clientId,type));
    }
    @Operation(summary = "Получить все контакты клиента по id клиента")
    @SneakyThrows
    @GetMapping("/get-all-contacts/{clientId}")
    public ResponseEntity<Map<ClientDTO, List<ContactShortDTO>>> getAllContacts(@PathVariable Long clientId) {
        return ResponseEntity.ok(contactService.getAllContacts(clientId));
    }

    @Operation(summary = "Изменить данные контакта по id")
    @SneakyThrows
    @PatchMapping("/update/{id}")
    public ResponseEntity<ContactDTO> updateById(@PathVariable Long id, @RequestBody ContactToSaveDTO info) {
        return ResponseEntity.ok(contactService.update(id,info));
    }
    @Operation(summary = "Получить запись контакта по id")
    @SneakyThrows
    @GetMapping("/get/{id}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Long id) {
        return ResponseEntity.ok(contactService.getById(id));
    }
    @Operation(summary = "Удалить контакт по его id")
    @SneakyThrows
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
}
