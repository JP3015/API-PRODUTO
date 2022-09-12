package com.backend.estoque.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.estoque.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	public List<Pedido> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
