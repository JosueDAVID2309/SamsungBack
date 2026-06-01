package com.tarea.samsungshop.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "especificaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Especificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "producto_idproducto", nullable = false)
    private Producto producto;
}