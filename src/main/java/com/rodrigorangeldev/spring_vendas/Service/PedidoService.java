package com.rodrigorangeldev.spring_vendas.Service;

import com.rodrigorangeldev.spring_vendas.Domain.Pedido;
import com.rodrigorangeldev.spring_vendas.Exceptions.ObjectNotFoundException;
import com.rodrigorangeldev.spring_vendas.Repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repository;

    public Optional<Pedido> findPedidoById(Integer id){

        Optional<Pedido> ped = repository.findById(id);
        if(ped.isEmpty()){
            throw new ObjectNotFoundException("Não localizado");
        }

        return ped;
    }
}
