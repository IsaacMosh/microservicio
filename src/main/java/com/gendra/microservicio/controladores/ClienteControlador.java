package com.gendra.microservicio.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gendra.microservicio.clases.Cliente;
import com.gendra.microservicio.servicio.ClienteServicio;

@RestController
@RequestMapping("/cliente")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicioImpl;
    
    @GetMapping
    @RequestMapping(value = "consultarCliente", method = RequestMethod.GET)
    public ResponseEntity<?> consultarCliente() {

        List<Cliente> clientesConsultados = this.clienteServicioImpl.consultarClientes();

        return ResponseEntity.ok(clientesConsultados);
    }

    @PostMapping
    @RequestMapping(value = "guardarCliente", method = RequestMethod.POST)
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente) {

        Cliente clienteGuardado = this.clienteServicioImpl.guardarCliente(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteGuardado);
    }

    @PutMapping
    @RequestMapping(value = "actualizarCliente", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente) {

        Cliente clienteActualizado = this.clienteServicioImpl.actualizarCliente(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteActualizado);
    }

    @DeleteMapping
    @RequestMapping(value = "eliminarCliente/{idCliente}", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarCliente(@PathVariable Integer idCliente) {

        this.clienteServicioImpl.eliminarCliente(idCliente);

        return ResponseEntity.ok().build();
    }
}
