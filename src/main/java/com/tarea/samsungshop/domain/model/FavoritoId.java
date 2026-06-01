package com.tarea.samsungshop.domain.model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoritoId implements Serializable {

    private Integer productoId;
    private Integer usuarioId;
}
