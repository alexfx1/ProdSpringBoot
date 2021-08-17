package com.springboot1.Produtos.repository;

import com.springboot1.Produtos.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findById(long id);
}
