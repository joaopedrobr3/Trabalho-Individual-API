package org.serratec.Ong.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonPropertyOrder({
    "id",
    "nome",
    "sexo",
    "porte",
    "especie"

})
public class AnimalDTOResponse {
   
    private Long id;
    private String nome;
    private String sexo;
    private String porte;
    private String especie;

    
    
    public AnimalDTOResponse() {
    }

   
    
    public AnimalDTOResponse(Long id, String nome, String sexo, String porte, String especie) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.porte = porte;
        this.especie = especie;
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



    public String getEspecie() {
        return especie;
    }



    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    
    
}
