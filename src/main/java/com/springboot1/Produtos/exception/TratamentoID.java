package com.springboot1.Produtos.exception;

import com.springboot1.Produtos.service.ClienteService;
import com.springboot1.Produtos.service.ItemPedidoService;
import com.springboot1.Produtos.service.PedidoService;
import com.springboot1.Produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;

public class TratamentoID {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private ItemPedidoService itemPedidoService;

    public void verificaIdCliente(long id){
        if(clienteService.findById(id) == null)
            throw new RegrasDeNegocio( "Cliente nao encontrado com esse id " + id);
    }

    public void verificaIdProduto(long id){
        if(produtoService.findById(id) == null)
            throw new RegrasDeNegocio( "Produto nao encontrado com esse id " + id);
    }

    public void verificaIdPedido(long id){
        if(pedidoService.findById(id) == null)
            throw new RegrasDeNegocio( "Pedido nao encontrado com esse id " + id);
    }

    public void verificaIdItemPedido(long id){
        if(itemPedidoService.findById(id) == null)
            throw new RegrasDeNegocio( "Item nao encontrado com esse id " + id);
    }
}
