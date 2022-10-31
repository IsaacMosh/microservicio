package com.gendra.microservicio.servicio.Impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.gendra.microservicio.clases.Orden;
import com.gendra.microservicio.repositorio.OrdenRepositorio;
import com.gendra.microservicio.servicio.OrdenServicio;

public class OrdenServicioImpl implements OrdenServicio {

    @Autowired
    private OrdenRepositorio ordenRepositorio;

    @Override
    public List<Orden> consultarOrdenes() {
        
        List<Orden> ordenDataSource = StreamSupport.stream(
            this.ordenRepositorio.findAll().spliterator(), false)
            .collect(Collectors.toList());

        return ordenDataSource;
    }

    @Override
    public Orden guardarOrden(Orden orden) {        
        return this.ordenRepositorio.save(orden);
    }

    @Override
    public void eliminarOrden(Integer idorden) {
        this.ordenRepositorio.deleteById(idorden);     
    }

    @Override
    public Orden actualizarOrden(Orden orden) {
        return this.ordenRepositorio.save(orden);
    }
    
}
