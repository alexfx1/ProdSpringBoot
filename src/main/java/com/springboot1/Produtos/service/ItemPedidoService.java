package com.springboot1.Produtos.service;

import com.springboot1.Produtos.models.ItemPedido;
import com.springboot1.Produtos.models.Produto;
import com.springboot1.Produtos.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public ItemPedido findById(long id){
        return itemPedidoRepository.findById(id);
    }

    public List<ItemPedido> findAll(){
        return itemPedidoRepository.findAll();
    }

    public ItemPedido save(@RequestBody ItemPedido itemPedido){
        return itemPedidoRepository.save(itemPedido);
    }

    public void delete(@RequestBody ItemPedido itemPedido){
        itemPedidoRepository.delete(itemPedido);
    }

    public double precoFinalItem(Produto produto, double quantidade, double desconto){
        double precoFinal;
        double vp = produto.getTotal();
        precoFinal = vp * quantidade - desconto;
        return precoFinal;
    }
}