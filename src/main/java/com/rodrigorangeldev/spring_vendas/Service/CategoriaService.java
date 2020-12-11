package com.rodrigorangeldev.spring_vendas.Service;

import com.rodrigorangeldev.spring_vendas.Domain.Categoria;
import com.rodrigorangeldev.spring_vendas.Exceptions.ObjectNotFoundException;
import com.rodrigorangeldev.spring_vendas.Repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public Optional<Categoria> findCategoriaById(Integer id){

        Optional<Categoria> cat = repository.findById(id);
        if(cat.isEmpty()){
            throw new ObjectNotFoundException("Não localizado");
        }

        return cat;
    }
}
