package com.springboot1.Produtos.repository;

import com.springboot1.Produtos.models.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    ItemPedido findById(long id);
}
