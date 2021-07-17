package com.romulosilva.cursomc.repositories;

import com.romulosilva.cursomc.domain.Categoria;
import com.romulosilva.cursomc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
