package com.romulosilva.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romulosilva.cursomc.domain.Categoria;
import com.romulosilva.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;

	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
				
		
	}
}
