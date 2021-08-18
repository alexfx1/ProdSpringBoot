package com.springboot1.Produtos.resourses;

import com.springboot1.Produtos.exception.RegrasDeNegocio;
import com.springboot1.Produtos.models.ItemPedido;
import com.springboot1.Produtos.models.Pedido;
import com.springboot1.Produtos.models.Produto;
import com.springboot1.Produtos.service.ItemPedidoService;
import com.springboot1.Produtos.service.PedidoService;
import com.springboot1.Produtos.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API com JAVA - Produtos")  // <------ nomear api
@CrossOrigin(origins = "*")              // <------ Restrição na web * significa que qualquer site podera entrar
public class ItemPedidoResource {

    @Autowired
    ItemPedidoService itemPedidoService;

    @Autowired
    PedidoService pedidoService;

    @Autowired
    ProdutoService produtoService;

    private void verificaIdItemPedido(long id){
        if(itemPedidoService.findById(id) == null)
            throw new RegrasDeNegocio( "Item nao encontrado com esse id " + id);
    }

    // METODO GET API
    @GetMapping("/itempedido")
    @ApiOperation("Listar Itens")
    public ResponseEntity<List<ItemPedido>> listaItemPedido(){
        List<ItemPedido> list = itemPedidoService.findAll();
        return ResponseEntity.ok().body(list);
    }


    @GetMapping("/itempedido/{id}")
    @ApiOperation(value = "Pedido unico")
    public ResponseEntity<ItemPedido> listaPedidoUnico(@PathVariable(value="id") long id){
        ItemPedido itemPedido = itemPedidoService.findById(id);

        return ResponseEntity.ok().body(itemPedido);
    }

    @PostMapping("/itempedido")
    @ApiOperation(value = "Salva um item")
    public ItemPedido salvaItem(@RequestBody ItemPedido itemPedido){
        //recupera o pedido
        Pedido pedido = pedidoService.findById(itemPedido.getPedido().getId());
        itemPedido.setPedido(pedido);

        //recupera o produto
        Produto produto = produtoService.findById(itemPedido.getProduto().getId());
        itemPedido.setProduto(produto);
        return itemPedidoService.save(itemPedido);
    }

    @DeleteMapping("/itempedido/{id}")
    @ApiOperation(value = "delete item")
    public ResponseEntity<ItemPedido> deletar(@PathVariable(value = "id") long id) {
        verificaIdItemPedido(id);
        ItemPedido itemPedido = itemPedidoService.findById(id);
        itemPedidoService.delete(itemPedido);
        return ResponseEntity.ok().body(itemPedido);
    }

    @PutMapping("/itempedido")
    @ApiOperation(value = "Atualiza item")
    public ItemPedido atualizaItem(@RequestBody ItemPedido itemPedido){

        return itemPedidoService.save(itemPedido);
    }

    @PutMapping("/itempedido/{id}")
    public void atualizaItemPedido(@PathVariable(value = "id")long id){
        ItemPedido itemPedido = itemPedidoService.findById(id);
        itemPedidoService.save(itemPedido);
    }
}