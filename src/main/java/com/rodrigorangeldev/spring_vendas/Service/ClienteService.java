package com.rodrigorangeldev.spring_vendas.Service;

import com.rodrigorangeldev.spring_vendas.Domain.Cliente;
import com.rodrigorangeldev.spring_vendas.Exceptions.ObjectNotFoundException;
import com.rodrigorangeldev.spring_vendas.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public Optional<Cliente> findClienteById(Integer id){

        Optional<Cliente> cliente = repository.findById(id);
        if(cliente.isEmpty()){
            throw new ObjectNotFoundException("Não localizado");
        }

        return cliente;
    }
}
