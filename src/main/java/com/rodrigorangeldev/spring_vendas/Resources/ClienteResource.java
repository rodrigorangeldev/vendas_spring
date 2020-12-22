package com.rodrigorangeldev.spring_vendas.Resources;

import com.rodrigorangeldev.spring_vendas.Domain.Cliente;
import com.rodrigorangeldev.spring_vendas.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){

        Optional<Cliente> res = clienteService.findClienteById(id);

        return new ResponseEntity(res, HttpStatus.OK);

    }

}
