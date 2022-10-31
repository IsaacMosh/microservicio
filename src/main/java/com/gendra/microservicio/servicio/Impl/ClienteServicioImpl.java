package com.gendra.microservicio.servicio.Impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gendra.microservicio.clases.Cliente;
import com.gendra.microservicio.repositorio.ClienteRepositorio;
import com.gendra.microservicio.servicio.ClienteServicio;

//import com.gendra.microservicio.servicio.ClienteServicio;
@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;
    
    @Override
    public List<Cliente> consultarClientes() {
        
        List<Cliente> clienteDataSource = StreamSupport.stream(
            this.clienteRepositorio.findAll().spliterator(), false)
            .collect(Collectors.toList());

        return clienteDataSource;
    }

    @Override
    public Cliente guardarCliente(Cliente cliente) {                
        return this.clienteRepositorio.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {        
        return this.clienteRepositorio.save(cliente);
    }

    @Override
    public void eliminarCliente(Integer idCliente) {        
        this.clienteRepositorio.deleteById(idCliente);
    }
}
