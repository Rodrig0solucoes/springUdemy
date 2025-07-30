package com.rodrigo.projSpring;

import com.rodrigo.projSpring.dominio.*;
import com.rodrigo.projSpring.dominio.enuns.TipoCliente;
import com.rodrigo.projSpring.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class ProjSpringApplication implements CommandLineRunner  {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutosRepository produtosRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produtos p1 = new Produtos(null, "Computados", 2000.00);
		Produtos p2 = new Produtos(null, "Impresora", 800.00);
		Produtos p3 = new Produtos(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtosRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "12345678954", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("21586874", "58965235"));
		Endereco ed1 = new Endereco(null, "Rua das flores","25","Apto", "Jardins", "32536525", cli1, c1);
		Endereco ed2 = new Endereco(null, "Av Matos","105","Sala 800", "Centro", "36985214", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(ed1, ed2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(ed1, ed2));


	}
}
