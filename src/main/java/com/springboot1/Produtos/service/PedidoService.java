package com.springboot1.Produtos.service;

import com.springboot1.Produtos.enums.UF;
import com.springboot1.Produtos.models.Pedido;
import com.springboot1.Produtos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
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

    public void calcFrete(BigDecimal frete){
        Pedido pedido = new Pedido();
        BigDecimal val1 = new BigDecimal("1.1");
        BigDecimal val2 = new BigDecimal("1.5");
        BigDecimal val3 = new BigDecimal("1.3");

        if(pedido.getCliente().getEndereco().getEstado() == UF.GO){
            frete = frete.multiply(val1);
            pedido.setFrete(frete);
        }
        else if(pedido.getCliente().getEndereco().getEstado() == UF.TO){
            frete = frete.multiply(val2);
            pedido.setFrete(frete);
        }
        else {
            frete = frete.multiply(val3);
            pedido.setFrete(frete);
        }
    }
}