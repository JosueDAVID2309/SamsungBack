package com.tarea.samsungshop.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favorito")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Favorito {

    @EmbeddedId
    private FavoritoId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productoId")
    @JoinColumn(name = "producto_idproducto")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("usuarioId")
    @JoinColumn(name = "usuario_idUsuario")
    private Usuario usuario;
}
