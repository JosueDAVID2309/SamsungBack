package com.tarea.samsungshop.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "serie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "gama_idgama",
        nullable = false
    )
    private Gama gama;
}
