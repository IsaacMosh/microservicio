package com.gendra.microservicio.servicio;

import java.util.List;

import com.gendra.microservicio.clases.Cliente;

public interface ClienteServicio {
    
    List<Cliente> consultarClientes();

    Cliente guardarCliente(Cliente cliente);

    Cliente actualizarCliente(Cliente cliente);

    void eliminarCliente(Integer idCliente);
}
