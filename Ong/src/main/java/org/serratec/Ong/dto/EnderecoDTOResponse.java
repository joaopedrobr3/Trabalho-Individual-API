package org.serratec.Ong.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class EnderecoDTOResponse {
    
    @JsonPropertyOrder({
       "cidade",
       "rua",
       "bairro",
       "numero"

    })


    private String cidade;
    private String rua;
    private String bairro;
    private Integer numero;
    
    
    
    public EnderecoDTOResponse() {
    }

    public EnderecoDTOResponse(String cidade, String rua, String bairro, Integer numero) {
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }
    
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public Integer getNumero() {
        return numero;
    }
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    
}
