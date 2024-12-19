package com.testTask.clientTask.repository;

import com.testTask.clientTask.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity,Long> {
}
