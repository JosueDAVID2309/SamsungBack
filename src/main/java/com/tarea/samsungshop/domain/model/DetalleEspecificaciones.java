package com.tarea.samsungshop.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_especificaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetalleEspecificaciones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String subtitulo;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "especificaciones_idespecificaciones", nullable = false)
    private Especificaciones especificaciones;
}