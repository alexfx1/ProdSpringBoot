package com.springboot1.Produtos.service;

import com.springboot1.Produtos.models.Pedido;
import com.springboot1.Produtos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido findById(long id){
        return pedidoRepository.findById(id);
    }

    public List<Pedido> findAll(){
        return pedidoRepository.findAll();
    }

    public Pedido save(@RequestBody Pedido pedido){
        return pedidoRepository.save(pedido);
    }

    public void delete(@RequestBody Pedido pedido){
        pedidoRepository.delete(pedido);
    }

}