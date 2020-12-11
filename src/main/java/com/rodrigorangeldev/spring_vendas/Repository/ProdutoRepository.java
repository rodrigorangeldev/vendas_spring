package com.rodrigorangeldev.spring_vendas.Repository;

import com.rodrigorangeldev.spring_vendas.Domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
