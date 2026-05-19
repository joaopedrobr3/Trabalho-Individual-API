package org.serratec.Ong.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class AnimalDTOResponse {
    
    @JsonPropertyOrder({
        "id",
        "nome",
        "sexo",
        "porte",
        "raca"

    })
   
    private Long id;
    private String nome;
    private String sexo;
    private String porte;
    private String raca;

    
    
    public AnimalDTOResponse() {
    }

    public AnimalDTOResponse(Long id, String nome, String sexo, String porte, String raca) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.porte = porte;
        this.raca = raca;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getPorte() {
        return porte;
    }
    public void setPorte(String porte) {
        this.porte = porte;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    
    
}
