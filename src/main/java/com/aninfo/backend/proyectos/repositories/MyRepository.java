package com.aninfo.backend.proyectos.repositories;


import com.aninfo.backend.proyectos.models.MyModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MyRepository extends CrudRepository<MyModel, Long> { }