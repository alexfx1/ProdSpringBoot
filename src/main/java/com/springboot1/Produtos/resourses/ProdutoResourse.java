package com.springboot1.Produtos.resourses;

//CONTROLLER

import com.springboot1.Produtos.models.Produto;
import com.springboot1.Produtos.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API com JAVA - Produtos")  // <------ nomear api
@CrossOrigin(origins = "*")              // <------ Restrição na web * significa que qualquer site podera entrar
public class ProdutoResourse {

    @Autowired
    ProdutoService produtoService;

    // METODO GET API
    @GetMapping("/produto")
    @ApiOperation(value = "Lista de produtos")
    public List<Produto> listaProdutos(){
        return produtoService.findAll();
    }

    // GET SOMENTE 1 Produto
    @GetMapping("/produto/{id}")
    @ApiOperation(value = "Produto unico")
    public Produto listaProdutoUnico(@PathVariable(value="id") long id){
        return produtoService.findById(id);
    }

    // SALVAR NOVO PRODUTO
    @PostMapping("/produto")
    @ApiOperation(value = "Salva um produto")
    public Produto salvaProduto(@RequestBody Produto produto){
        return produtoService.save(produto);
    }

    //NAO EH POR ID, NO POST TEM Q COLOCAR OS DADOS
    @DeleteMapping("/produto/{id}")
    @ApiOperation(value = "deleta um produto")
    public void deletaProduto(@PathVariable(value = "id")long id){
        Produto produto = produtoService.findById(id);
        produtoService.delete(produto);
    }

    @PutMapping("/produto")
    @ApiOperation(value = "Atualiza produto")
    public Produto atualizaProduto(@RequestBody Produto produto){

        return produtoService.save(produto);
    }

    @PutMapping("/produto/{id}")
    public void atualizaProdutoId(@PathVariable(value = "id")long id){
        Produto produto = produtoService.findById(id);
        produtoService.save(produto);
    }

}