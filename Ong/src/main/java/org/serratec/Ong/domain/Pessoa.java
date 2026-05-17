package org.serratec.Ong.domain;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O campo 'nome' não pode ficar vazio")
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @NotBlank(message = "O campo 'telefone' não pode ficar vazio")
    @Size(max = 10, min = 10, message = "O telefone precisa ter 10 caracteres! Digite apenas números")
    @Column(name = "telefone", nullable = false, length = 10)
    private String telefone;
    
    @NotBlank(message = "O campo 'cpf' não pode ficar vazio")
    @CPF
    @Size(max = 11, min = 11, message = "O CPF precisa ter 11 caracteres! Digite apenas números" )
    @Column(name = "cpf", nullable = false, length = 11)
    private String cpf;
    
    @Email(message = "O campo 'email' precisa ser um email válido")
    @Column(name = "email")
    private String email;

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
