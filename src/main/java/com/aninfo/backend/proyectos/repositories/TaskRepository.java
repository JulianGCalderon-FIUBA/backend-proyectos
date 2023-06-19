package com.aninfo.backend.proyectos.repositories;


import com.aninfo.backend.proyectos.models.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Collection<Task> findAllByProjectId(Long projectId);
}