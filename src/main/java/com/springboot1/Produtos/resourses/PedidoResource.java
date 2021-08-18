package com.springboot1.Produtos.resourses;

import com.springboot1.Produtos.models.Cliente;
import com.springboot1.Produtos.models.Pedido;
import com.springboot1.Produtos.service.ClienteService;
import com.springboot1.Produtos.service.PedidoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping(value = "/api")
@Api(value = "API com JAVA - Produtos")  // <------ nomear api
@CrossOrigin(origins = "*")              // <------ Restrição na web * significa que qualquer site podera entrar
public class PedidoResource {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    ClienteService clienteService;

    @GetMapping("/pedidos")
    @ApiOperation("Listar pedidos")
    public ResponseEntity<List<Pedido>> listaPedidos(){
        List<Pedido> list = pedidoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    // GET SOMENTE 1 Pedido
    @GetMapping("/pedidos/{id}")
    @ApiOperation(value = "Pedido unico")
    public ResponseEntity<Pedido> listaPedidoUnico(@PathVariable(value="id") long id){
        Pedido pedido = pedidoService.findById(id);

        return ResponseEntity.ok().body(pedido);
    }

    // SALVAR NOVO PEDIDO
    @PostMapping("/pedido")
    @ApiOperation(value = "Salva um pedido")
    public Pedido salvaPedido(@RequestBody Pedido pedido){
        //recuperar o cliente
        Cliente cliente = clienteService.findById(pedido.getCliente().getId());
        pedido.setCliente(cliente);

        pedidoService.calcFrete(pedido.getFrete());
        return pedidoService.save(pedido);
    }

    //NAO EH POR ID, NO POST TEM Q COLOCAR OS DADOS
    @DeleteMapping("/pedido/{id}")
    @ApiOperation(value = "deleta um pedido")
    public void deletaPedido(@PathVariable(value = "id")long id){
        Pedido pedido = pedidoService.findById(id);
        pedidoService.delete(pedido);
    }

    @PutMapping("/pedido")
    @ApiOperation(value = "Atualiza pedido")
    public Pedido atualizaPedido(@RequestBody Pedido pedido){

        return pedidoService.save(pedido);
    }

    @PutMapping("/pedido/{id}")
    public void atualizaProdutoId(@PathVariable(value = "id")long id){
        Pedido pedido = pedidoService.findById(id);
        pedidoService.save(pedido);
    }
}
