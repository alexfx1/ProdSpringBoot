package com.springboot1.Produtos.resourses;

//CONTROLLER

import com.springboot1.Produtos.exception.RegrasDeNegocio;
import com.springboot1.Produtos.models.Produto;
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
public class ProdutoResourse {

    @Autowired
    ProdutoService produtoService;

    private void verificaIdProduto(long id){
        if(produtoService.findById(id) == null)
            throw new RegrasDeNegocio( "Produto nao encontrado com esse id " + id);
    }

    // METODO GET API
    @GetMapping("/produtos")
    @ApiOperation("Listar produtos")
    public ResponseEntity<List<Produto>> listaProdutos(){
        List<Produto> list = produtoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    // GET SOMENTE 1 Produto
    @GetMapping("/produtos/{id}")
    @ApiOperation(value = "Produto unico")
    public ResponseEntity<Produto> listaProdutoUnico(@PathVariable(value="id") long id){
        verificaIdProduto(id);
        Produto produto = produtoService.findById(id);
        return ResponseEntity.ok().body(produto);
    }

    // SALVAR NOVO PRODUTO
    @PostMapping("/produto")
    @ApiOperation(value = "Salva um produto")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoService.save(produto);
    }

    //NAO EH POR ID, NO POST TEM Q COLOCAR OS DADOS
    @DeleteMapping("/produto/{id}")
    @ApiOperation(value = "delete produto")
    public ResponseEntity<Produto> deletar(@PathVariable(value = "id") long id) {
        verificaIdProduto(id);
        Produto produto = produtoService.findById(id);
        produtoService.delete(produto);
        return ResponseEntity.ok().body(produto);
    }

    @PutMapping("/produto/{id}")
    public void atualizaProdutoId(@PathVariable(value = "id")long id){
        Produto produto = produtoService.findById(id);
        produtoService.save(produto);
    }
}