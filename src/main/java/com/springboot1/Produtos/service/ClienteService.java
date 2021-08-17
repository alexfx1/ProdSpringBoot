package com.springboot1.Produtos.service;

import com.springboot1.Produtos.models.Cliente;
import com.springboot1.Produtos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(long id){
        return clienteRepository.findById(id);
    }

    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    public Cliente save(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public void delete(@RequestBody Cliente cliente){
         clienteRepository.delete(cliente);
    }
}
