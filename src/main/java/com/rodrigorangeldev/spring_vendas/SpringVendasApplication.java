package com.rodrigorangeldev.spring_vendas;

import com.rodrigorangeldev.spring_vendas.Domain.*;
import com.rodrigorangeldev.spring_vendas.Enums.TipoCliente;
import com.rodrigorangeldev.spring_vendas.Repository.*;
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
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;


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

		Cliente cli1 = new Cliente(null, "Maria da Silva", "asd@adwd.com", "448877995544", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("719955448866", "718844668899"));
		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Apto 303", "Jardim", "41000000", cli1, c1);
		Endereco end2 = new Endereco(null, "Rua Floresta", "299", "Apto 105", "Lapa", "41000000", cli1, c2);

		cli1.getEndereco().addAll(Arrays.asList(end1, end2));

		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(end1, end2));

	}
}
