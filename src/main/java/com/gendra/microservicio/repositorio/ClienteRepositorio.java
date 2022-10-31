package com.gendra.microservicio.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.gendra.microservicio.clases.Cliente;

public interface ClienteRepositorio extends CrudRepository<Cliente, Integer> {
    
}
