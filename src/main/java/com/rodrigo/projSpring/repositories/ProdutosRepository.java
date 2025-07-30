package com.rodrigo.projSpring.repositories;

import com.rodrigo.projSpring.dominio.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Integer> {
}
