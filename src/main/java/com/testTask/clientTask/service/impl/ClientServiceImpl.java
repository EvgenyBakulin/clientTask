package com.testTask.clientTask.service.impl;

import com.testTask.clientTask.dto.ClientDTO;
import com.testTask.clientTask.dto.ClientToSaveDTO;
import com.testTask.clientTask.dto.mapper.ClientMapper;
import com.testTask.clientTask.exception.EmptyValueException;
import com.testTask.clientTask.exception.NotFoundException;
import com.testTask.clientTask.model.ClientEntity;
import com.testTask.clientTask.repository.ClientRepository;
import com.testTask.clientTask.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientDTO addClient(ClientToSaveDTO info) {
        if(info.getName().isEmpty())
            throw new EmptyValueException("Имя клиента не должно быть пустым полем!");
        ClientEntity client = new ClientEntity();
        client.setName(info.getName());
        return clientMapper.toDTO(clientRepository.save(client));
    }

    @Override
    public ClientDTO getClient(Long id) {
        return clientMapper.toDTO(clientRepository.findById(id).orElseThrow(()->new NotFoundException("Клиент не найден!")));
    }

    @Override
    public ClientDTO update(Long id, ClientToSaveDTO info) {
        if(info.getName().isEmpty())
            throw new EmptyValueException("Имя клиента не должно быть пустым полем!");
        ClientEntity client = clientRepository.findById(id).orElseThrow(()->new NotFoundException("Клиент не найден!"));
        client.setName(info.getName());
        return clientMapper.toDTO(clientRepository.save(client));
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.delete((clientRepository.findById(id).orElseThrow(()->new NotFoundException("Клиент не найден!"))));
    }

    @Override
    public List<ClientDTO> getAll() {
        return clientRepository.findAll().stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }

}
