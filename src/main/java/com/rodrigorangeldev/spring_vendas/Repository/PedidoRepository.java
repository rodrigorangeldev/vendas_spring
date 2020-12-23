package com.rodrigorangeldev.spring_vendas.Repository;

import com.rodrigorangeldev.spring_vendas.Domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
