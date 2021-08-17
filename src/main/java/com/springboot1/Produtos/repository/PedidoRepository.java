package com.springboot1.Produtos.repository;

import com.springboot1.Produtos.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    Pedido findById(long id);
}
