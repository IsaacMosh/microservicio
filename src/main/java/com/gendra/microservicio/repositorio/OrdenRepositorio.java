package com.gendra.microservicio.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.gendra.microservicio.clases.Orden;

public interface OrdenRepositorio extends CrudRepository<Orden, Integer> {
    
}
