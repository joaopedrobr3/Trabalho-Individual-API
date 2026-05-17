package org.serratec.Ong.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PessoaRequest {
     
    
    
    @NotBlank(message = "O campo 'nome' não pode ficar vazio")
    private String nome;

    @NotBlank(message = "O campo 'telefone' não pode ficar vazio")
    @Size(max = 10, min = 10, message = "O telefone precisa ter 10 caracteres!")
    private String telefone;

    @NotBlank(message = "O campo 'cpf' não pode ficar vazio")
    @Size(max = 11, min = 11, message = "O CPF precisa ter 11 caracteres!")
    private String cpf;

    @Email(message = "Informe um email válido")
    private String email;

    @NotNull(message = "O campo 'idEndereco' não pode ficar vazio")
    private Long idEndereco;

   
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

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    
}
