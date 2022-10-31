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

import com.gendra.microservicio.clases.Orden;
import com.gendra.microservicio.servicio.OrdenServicio;

@RestController
@RequestMapping("/orden")
public class OrdenControlador {

    @Autowired
    private OrdenServicio ordenServicioImpl;
    
    @GetMapping
    @RequestMapping(value = "consultarOrden", method = RequestMethod.GET)
    public ResponseEntity<?> consultarOrden() {

        List<Orden> ordenesConsultadas = this.ordenServicioImpl.consultarOrdenes();

        return ResponseEntity.ok(ordenesConsultadas);
    }

    @PostMapping
    @RequestMapping(value = "guardarOrden", method = RequestMethod.POST)
    public ResponseEntity<?> guardarOrden(@RequestBody Orden orden) {

        Orden ordenGuardada = this.ordenServicioImpl.guardarOrden(orden);

        return ResponseEntity.status(HttpStatus.CREATED).body(ordenGuardada);
    }

    @PutMapping
    @RequestMapping(value = "actualizarOrden", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarOrden(@RequestBody Orden orden) {

        Orden ordenActualizada = this.ordenServicioImpl.actualizarOrden(orden);

        return ResponseEntity.status(HttpStatus.CREATED).body(ordenActualizada);
    }

    @DeleteMapping
    @RequestMapping(value = "eliminarOrden", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarOrden(@PathVariable Integer idorden) {

        this.ordenServicioImpl.eliminarOrden(idorden);

        return ResponseEntity.ok().build();
    }
    
}
