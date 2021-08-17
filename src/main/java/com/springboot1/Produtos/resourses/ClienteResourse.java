package com.springboot1.Produtos.resourses;


import com.springboot1.Produtos.exception.RegrasDeNegocio;
import com.springboot1.Produtos.models.Cliente;
import com.springboot1.Produtos.service.ClienteService;
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
@RequestMapping("/api")
@Api(value = "Cadastro de clientes")
@CrossOrigin("*")
public class ClienteResourse {

    private void verificaIdCliente(long id){
        if(clienteService.findById(id) == null)
            throw new RegrasDeNegocio( "Cliente nao encontrado com esse id " + id);
    }
    //500

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    @ApiOperation("Listar clientes")
    public ResponseEntity<List<Cliente>> listaClientes(){
        List<Cliente> list = clienteService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/clientes/{id}")
    @ApiOperation(value = "Cliente unico")
    public ResponseEntity<Cliente> listaClienteUnico(@PathVariable(value="id") long id){
        verificaIdCliente(id);
        Cliente cliente = clienteService.findById(id);
        return ResponseEntity.ok().body(cliente);
    }

    @PostMapping("/cliente")
    @ApiOperation("Cadastro novo cliente")
    public Cliente salvaCliente(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @DeleteMapping("/cliente/{id}")
    @ApiOperation(value = "delete cliente")
    public ResponseEntity<Cliente> deletar(@PathVariable(value = "id") long id) {
        verificaIdCliente(id);
        Cliente cliente = clienteService.findById(id);
        clienteService.delete(cliente);
        return ResponseEntity.ok().body(cliente);
    }

    @PutMapping("/cliente")
    @ApiOperation(value = "Atualiza cliente")
    public Cliente atualizaCliente(@RequestBody Cliente cliente){
        verificaIdCliente(cliente.getId());
        return clienteService.save(cliente);
    }

    @PutMapping("/cliente/{id}")
    public Cliente atualizar(@PathVariable(value = "id") long id){
        Cliente cliente = clienteService.findById(id);
        return clienteService.save(cliente);
    }
}
