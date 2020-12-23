package com.rodrigorangeldev.spring_vendas.Repository;

import com.rodrigorangeldev.spring_vendas.Domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
