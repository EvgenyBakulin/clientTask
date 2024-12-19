package com.testTask.clientTask.service;

import com.testTask.clientTask.dto.ClientDTO;
import com.testTask.clientTask.dto.ClientToSaveDTO;

import java.util.List;

public interface ClientService {
    ClientDTO addClient(ClientToSaveDTO info);
    ClientDTO getClient (Long id);
    ClientDTO update(Long id, ClientToSaveDTO info );
    void deleteClient(Long id);
    List<ClientDTO> getAll();
}
