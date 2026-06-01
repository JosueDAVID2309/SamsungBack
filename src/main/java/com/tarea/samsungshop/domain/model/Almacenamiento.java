package com.tarea.samsungshop.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Almacenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cantidad", nullable = false, length = 20)
    private String cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "producto_idproducto",
        nullable = false
    )
    private Producto producto;
}
