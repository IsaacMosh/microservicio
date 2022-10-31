package com.gendra.microservicio.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.gendra.microservicio.clases.Producto;

public interface ProductoRepositorio extends CrudRepository<Producto, Integer> {
    
}
