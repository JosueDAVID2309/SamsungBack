package com.tarea.samsungshop.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarea.samsungshop.domain.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}