package com.romulosilva.cursomc.dto;

import com.romulosilva.cursomc.domain.Categoria;

import java.io.Serializable;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUID = 5086138411453947520L;

    private Integer id;
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {
        id = categoria.getId();
        nome = categoria.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
