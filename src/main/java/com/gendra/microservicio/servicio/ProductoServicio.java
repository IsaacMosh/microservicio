package com.gendra.microservicio.servicio;

import java.util.List;

import com.gendra.microservicio.clases.Producto;

public interface ProductoServicio {
    
    List<Producto> consultarProductos();

    Producto guardarProducto(Producto producto);

    Producto actualizarProducto(Producto producto);

    void eliminarProducto(Integer idproducto);
}
