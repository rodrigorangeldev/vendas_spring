package com.rodrigorangeldev.spring_vendas;

import com.rodrigorangeldev.spring_vendas.Domain.Categoria;
import com.rodrigorangeldev.spring_vendas.Domain.Cidade;
import com.rodrigorangeldev.spring_vendas.Domain.Estado;
import com.rodrigorangeldev.spring_vendas.Domain.Produto;
import com.rodrigorangeldev.spring_vendas.Repository.CategoriaRepository;
import com.rodrigorangeldev.spring_vendas.Repository.CidadeRepository;
import com.rodrigorangeldev.spring_vendas.Repository.EstadoRepository;
import com.rodrigorangeldev.spring_vendas.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringVendasApplication  implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;


	public static void main(String[] args)  {
		SpringApplication.run(SpringVendasApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat2));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado e1 = new Estado(null, "Bahia");
		Estado e2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Salvador", e1);
		Cidade c2 = new Cidade(null, "São Paulo", e2);
		Cidade c3 = new Cidade(null, "Campinas", e2);

		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2,c3));

		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));


	}
}
