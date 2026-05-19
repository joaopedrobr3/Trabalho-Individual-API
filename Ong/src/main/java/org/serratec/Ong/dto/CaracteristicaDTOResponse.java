package org.serratec.Ong.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class CaracteristicaDTOResponse {
    
    @JsonPropertyOrder({
        "personalidade",
        "saude"
    })

    private String personalidade;
    private String saude;
    
    
    public CaracteristicaDTOResponse() {
    }

    public CaracteristicaDTOResponse(String personalidade, String saude) {
        this.personalidade = personalidade;
        this.saude = saude;
    }
    
    public String getPersonalidade() {
        return personalidade;
    }
    public void setPersonalidade(String personalidade) {
        this.personalidade = personalidade;
    }
    public String getSaude() {
        return saude;
    }
    public void setSaude(String saude) {
        this.saude = saude;
    }

    
}
