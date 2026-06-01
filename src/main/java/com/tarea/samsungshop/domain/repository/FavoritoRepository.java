package com.tarea.samsungshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarea.samsungshop.domain.model.Favorito;
import com.tarea.samsungshop.domain.model.FavoritoId;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, FavoritoId> {
    
}