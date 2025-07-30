package com.rodrigo.projSpring.services;

import com.rodrigo.projSpring.dominio.Categoria;
import com.rodrigo.projSpring.repositories.CategoriaRepository;
import com.rodrigo.projSpring.services.exceptions.ObjectNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria buscar(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExceptions(
                "objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()
        ));
    }
}
