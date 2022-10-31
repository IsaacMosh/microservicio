package com.gendra.microservicio.servicio;

import java.util.List;

import com.gendra.microservicio.clases.Orden;

public interface OrdenServicio {
    
    List<Orden> consultarOrdenes();

    Orden guardarOrden(Orden orden);

    Orden actualizarOrden(Orden orden);

    void eliminarOrden(Integer idorden);
}
