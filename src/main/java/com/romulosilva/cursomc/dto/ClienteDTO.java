package com.romulosilva.cursomc.dto;

import com.romulosilva.cursomc.domain.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 2286337099664790381L;

    private Integer id;
    @NotEmpty(message = "Campo nome é de preenchimento obrigatório.")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres.")
    private String nome;

    @NotEmpty(message = "Campo e-mail é de preenchimento obrigatório.")
    @Email(message = "E-mail inválido.")
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        id = cliente.getId();
        nome = cliente.getNome();
        email = cliente.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
