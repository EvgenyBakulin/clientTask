package com.testTask.clientTask.repository;

import com.testTask.clientTask.model.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<TypeEntity, Integer> {
}
