package com.romulosilva.cursomc.services;

import com.romulosilva.cursomc.domain.Categoria;
import com.romulosilva.cursomc.domain.Pedido;
import com.romulosilva.cursomc.repositories.CategoriaRepository;
import com.romulosilva.cursomc.repositories.PedidoRepository;
import com.romulosilva.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido buscar(Integer id) {

        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
    }
}
