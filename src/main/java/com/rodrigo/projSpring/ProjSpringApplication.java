package com.rodrigo.projSpring;

import com.rodrigo.projSpring.dominio.Categoria;
import com.rodrigo.projSpring.dominio.Produtos;
import com.rodrigo.projSpring.repositories.CategoriaRepository;
import com.rodrigo.projSpring.repositories.ProdutosRepository;
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

	}
}
