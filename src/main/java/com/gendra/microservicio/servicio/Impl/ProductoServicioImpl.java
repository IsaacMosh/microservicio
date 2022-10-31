package com.gendra.microservicio.servicio.Impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;

import com.gendra.microservicio.clases.Producto;
import com.gendra.microservicio.repositorio.ProductoRepositorio;
import com.gendra.microservicio.servicio.ProductoServicio;

public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductoRepositorio productoRepositorio;

    @Override
    public List<Producto> consultarProductos() {
        
        List<Producto> productoDataSource = StreamSupport.stream(
            this.productoRepositorio.findAll().spliterator(), false)
            .collect(Collectors.toList());

        return productoDataSource;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return this.productoRepositorio.save(producto);
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return this.productoRepositorio.save(producto);
    }

    @Override
    public void eliminarProducto(Integer idproducto) {        
        this.productoRepositorio.deleteById(idproducto);
    }
    
}
