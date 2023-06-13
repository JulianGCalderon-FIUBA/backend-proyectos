package com.aninfo.backend.proyectos.repositories;


import com.aninfo.backend.proyectos.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> { }