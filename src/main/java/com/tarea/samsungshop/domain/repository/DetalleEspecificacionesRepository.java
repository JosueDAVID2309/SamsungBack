package com.tarea.samsungshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarea.samsungshop.domain.model.DetalleEspecificaciones;

@Repository
public interface DetalleEspecificacionesRepository extends JpaRepository<DetalleEspecificaciones, Long> {
}