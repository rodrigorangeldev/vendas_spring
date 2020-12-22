package com.rodrigorangeldev.spring_vendas.Repository;

import com.rodrigorangeldev.spring_vendas.Domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
