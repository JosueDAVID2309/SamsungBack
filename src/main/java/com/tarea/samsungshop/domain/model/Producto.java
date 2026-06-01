package com.tarea.samsungshop.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "producto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(name = "precio_inicial", nullable = false)
    private BigDecimal precioInicial;

    @Column(name = "codigo_producto", nullable = false, unique = true, length = 100)
    private String codigoProducto;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal descuento;

    @Column(name = "envio_domicilio", nullable = false)
    private Boolean envioDomicilio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_idcategoria", nullable = false)
    private Categoria categoria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "serie_idserie")
    private Serie serie;
}
