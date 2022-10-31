package com.gendra.microservicio.clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "orden")
public class Orden {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idorden")
    private Integer idorden;
    
    @Column(name = "idCliente")
    private Integer idCliente;

    @Column(name = "idproducto")
    private Integer idproducto;

    @Column(name = "observaciones")
    private String observaciones;
}
