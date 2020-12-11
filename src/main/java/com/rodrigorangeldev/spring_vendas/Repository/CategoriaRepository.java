package com.rodrigorangeldev.spring_vendas.Repository;

import com.rodrigorangeldev.spring_vendas.Domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
