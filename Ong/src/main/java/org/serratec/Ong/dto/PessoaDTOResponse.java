package org.serratec.Ong.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class PessoaDTOResponse {
    
    @JsonPropertyOrder({
        "id",
        "nome",
        "email",
        "cidade"
    })
    
    private Long id;
    private String nome;
    private String email;
    private String cidade;
    
    
    public PessoaDTOResponse() {
    }

    
    public PessoaDTOResponse(Long id, String nome, String email, String cidade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cidade = cidade;
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
    
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    

    
}
