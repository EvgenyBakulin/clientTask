package com.testTask.clientTask.repository;

import com.testTask.clientTask.model.ClientEntity;
import com.testTask.clientTask.model.ContactEntity;
import com.testTask.clientTask.model.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<ContactEntity,Long> {
    List<ContactEntity> findContactEntitiesByClientAndType(ClientEntity client, TypeEntity type);
}
