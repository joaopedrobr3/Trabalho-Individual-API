package org.serratec.Ong.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class PessoaDTOResponse {
    
    @JsonPropertyOrder({
        "id",
        "nome",
        "telefone",
        "email",
        "dataNascimento"
        
    })
    
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;
    
    
    public PessoaDTOResponse() {
    }

    
    


    





    public PessoaDTOResponse(Long id, String nome, String telefone, String email, String cidade,
            LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }











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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    


    public LocalDate getDataNascimento() {
        return dataNascimento;
    }


    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }











    public String getTelefone() {
        return telefone;
    }











    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
   
    
}
