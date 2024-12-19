package com.testTask.clientTask.service;

import com.testTask.clientTask.dto.*;

import java.util.List;
import java.util.Map;

public interface ContactService {
    ContactDTO addContact(ContactToSaveDTO info);
    Map<ClientDTO, List<ContactShortDTO>> getOneTypeContacts(Long clientId, Integer type);
    Map<ClientDTO, List<ContactShortDTO>> getAllContacts(Long clientId);
    ContactDTO getById(Long id);
    ContactDTO update(Long id, ContactToSaveDTO info );
    void deleteContact(Long id);
}
