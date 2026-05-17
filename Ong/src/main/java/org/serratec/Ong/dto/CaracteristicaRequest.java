package org.serratec.Ong.dto;


import jakarta.validation.constraints.NotBlank;

public class CaracteristicaRequest {
     
    @NotBlank(message = "O campo 'personalidade' não pode ser vazio")
    private String personalidade;
    
    @NotBlank(message = "O campo 'saude' não pode ficar vazio")
    private String saude;

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
