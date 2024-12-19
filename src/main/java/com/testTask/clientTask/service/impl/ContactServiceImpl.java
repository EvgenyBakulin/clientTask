package com.testTask.clientTask.service.impl;

import com.testTask.clientTask.dto.*;
import com.testTask.clientTask.dto.mapper.ClientMapper;
import com.testTask.clientTask.dto.mapper.ContactMapper;
import com.testTask.clientTask.exception.EmptyValueException;
import com.testTask.clientTask.exception.NotFoundException;
import com.testTask.clientTask.model.ClientEntity;
import com.testTask.clientTask.model.ContactEntity;
import com.testTask.clientTask.model.TypeEntity;
import com.testTask.clientTask.repository.ClientRepository;
import com.testTask.clientTask.repository.ContactRepository;
import com.testTask.clientTask.repository.TypeRepository;
import com.testTask.clientTask.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepository contactRepository;
    private final ClientRepository clientRepository;
    private final TypeRepository typeRepository;
    private final ContactMapper contactMapper;
    private final ClientMapper clientMapper;

    public ContactServiceImpl(ClientRepository clientRepository, ContactRepository contactRepository, TypeRepository typeRepository, ClientMapper clientMapper, ContactMapper contactMapper, ClientMapper clientMapper1) {
        this.clientRepository = clientRepository;
        this.contactRepository = contactRepository;
        this.typeRepository = typeRepository;
        this.contactMapper = contactMapper;
        this.clientMapper = clientMapper1;
    }

    @Override
    public ContactDTO addContact(ContactToSaveDTO info) {
        if (info.getValue().isEmpty())
            throw new EmptyValueException("Значение контакта не может быть пустым");
        ContactEntity contact = new ContactEntity();
       clientRepository.findById(info.getClientId()).orElseThrow(()->new NotFoundException("Такого клиента нет"));
        contact.setValue(info.getValue());
        contact.setClient( clientRepository.findById(info.getClientId()).orElseThrow(()->new NotFoundException("Такого клиента нет")));
        contact.setType(typeRepository.findById(info.getType()).orElseThrow(()->new NotFoundException("Такого типа контактов нет")));
        return contactMapper.toDTO(contactRepository.save(contact));
    }
    /**Данные по контактам и клиентам выдаются в виде мапы (клиент - список его контактов**/

    @Override
    public Map<ClientDTO, List<ContactShortDTO>> getOneTypeContacts(Long clientId, Integer typeId) {
        ClientEntity client = clientRepository.findById(clientId).orElseThrow(()->new NotFoundException("Клиент не найден"));
        TypeEntity type = typeRepository.findById(typeId).orElseThrow(()->new NotFoundException("Тип контакта не найден"));
        List<ContactShortDTO> res = contactRepository.findContactEntitiesByClientAndType(client,type).stream().map(contactMapper::toShortDTO).collect(Collectors.toList());
        Map<ClientDTO,List<ContactShortDTO>> result = new HashMap<>();
        result.put(clientMapper.toDTO(client),res);
        return result;
    }

    @Override
    public Map<ClientDTO, List<ContactShortDTO>> getAllContacts(Long clientId) {
        ClientEntity client = clientRepository.findById(clientId).orElseThrow(()->new NotFoundException("Клиент не найден"));
        List<Integer> types = typeRepository.findAll().stream().map(TypeEntity::getId).collect(Collectors.toList());
        List<ContactShortDTO> res = new ArrayList<>();
        if(!types.isEmpty()) {
            for (Integer t : types) {
                TypeEntity type = typeRepository.findById(t).get();
                res.addAll(contactRepository.findContactEntitiesByClientAndType(client, type).stream().map(contactMapper::toShortDTO).collect(Collectors.toList()));
            }
        }
        Map<ClientDTO,List<ContactShortDTO>> result = new HashMap<>();
        result.put(clientMapper.toDTO(client),res);
        return result;
    }

    @Override
    public ContactDTO getById(Long id) {
        return contactMapper.toDTO(contactRepository.findById(id).orElseThrow(()->new NotFoundException("Такой записи не найдено!")));
    }

    @Override
    public ContactDTO update(Long id, ContactToSaveDTO info) {
        if (info.getValue().isEmpty())
            throw new EmptyValueException("Значение контакта не может быть пустым");
        ContactEntity contact = contactRepository.findById(id).orElseThrow(()->new NotFoundException("Такая запись не найдена!"));
        contact.setValue(info.getValue());
        contact.setClient(clientRepository.findById(info.getClientId()).orElseThrow(()->new NotFoundException("Такого клиента нет")));
        contact.setType(typeRepository.findById(info.getType()).orElseThrow(()->new NotFoundException("Такого типа контактов нет")));
        return contactMapper.toDTO(contactRepository.save(contact));
    }

    @Override
    public void deleteContact(Long id) {
        ContactEntity contact = contactRepository.findById(id).orElseThrow(()->new NotFoundException("Тип не найден!"));
        contactRepository.delete(contact);
    }

}
