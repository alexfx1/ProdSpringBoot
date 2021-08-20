package com.springboot1.Produtos.service;

import com.springboot1.Produtos.models.Produto;
import com.springboot1.Produtos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//Dependencias
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(long id){
        return produtoRepository.findById(id);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto save(@RequestBody Produto produto){
        return produtoRepository.save(produto);
    }

    public void delete(@RequestBody Produto produto){
        produtoRepository.delete(produto);
    }

    public double precoFinal(double preco, double desconto){
        double total;
        total = preco - desconto;
        return total;
    }
}
