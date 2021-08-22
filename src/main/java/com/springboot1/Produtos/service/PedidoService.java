package com.springboot1.Produtos.service;

import com.springboot1.Produtos.enums.UF;
import com.springboot1.Produtos.models.ItemPedido;
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

    public double valorFinal(ItemPedido itemPedido, double desconto){
        double vI = itemPedido.getValor();
        double vf;
        vf = vI - desconto;
        return vf;
    }

    public double calFrete(double valorFinal){
        Pedido pedido = new Pedido();
        if(pedido.getCliente().getEndereco().getEstado().equals(UF.GO)){
            valorFinal = (valorFinal*1.1);
            return valorFinal;
        }
        else if(pedido.getCliente().getEndereco().getEstado().equals(UF.MG)){
            valorFinal = valorFinal*1.3;
            return valorFinal;
        }
        else{
            valorFinal = valorFinal*1.5;
            return valorFinal;
        }
    }
}