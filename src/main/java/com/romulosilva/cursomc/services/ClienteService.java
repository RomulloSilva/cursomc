package com.romulosilva.cursomc.services;

import com.romulosilva.cursomc.domain.Cliente;
import com.romulosilva.cursomc.repositories.ClienteRepository;
import com.romulosilva.cursomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente buscar(Integer id) {

        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }
}
