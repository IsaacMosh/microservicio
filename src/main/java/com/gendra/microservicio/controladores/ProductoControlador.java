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

import com.gendra.microservicio.clases.Producto;
import com.gendra.microservicio.servicio.ProductoServicio;

@RestController
@RequestMapping("/producto")
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicioImpl;
    
    @GetMapping
    @RequestMapping(value = "consultarProducto", method = RequestMethod.GET)
    public ResponseEntity<?> consultarProducto() {

        List<Producto> productosConsultados = this.productoServicioImpl.consultarProductos();

        return ResponseEntity.ok(productosConsultados);
    }

    @PostMapping
    @RequestMapping(value = "guardarProducto", method = RequestMethod.POST)
    public ResponseEntity<?> guardarProducto(@RequestBody Producto producto) {

        Producto productoGuardado = this.productoServicioImpl.guardarProducto(producto);

        return ResponseEntity.status(HttpStatus.CREATED).body(productoGuardado);
    }

    @PutMapping
    @RequestMapping(value = "actualizarProducto", method = RequestMethod.PUT)
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto) {

        Producto productoActualizado = this.productoServicioImpl.actualizarProducto(producto);

        return ResponseEntity.status(HttpStatus.CREATED).body(productoActualizado);
    }

    @DeleteMapping
    @RequestMapping(value = "eliminarProducto", method = RequestMethod.DELETE)
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer idproducto) {

        this.productoServicioImpl.eliminarProducto(idproducto);

        return ResponseEntity.ok().build();
    }
    
}
