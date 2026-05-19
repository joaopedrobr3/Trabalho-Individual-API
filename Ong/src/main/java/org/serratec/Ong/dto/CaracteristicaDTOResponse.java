package org.serratec.Ong.dto;



import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "personalidade",
    "saude"
})
public class CaracteristicaDTOResponse {
    
    
    private Long id;
    private String personalidade;
    private String saude;
    
    
    public CaracteristicaDTOResponse() {
    }

    
    
    
    public CaracteristicaDTOResponse(Long id, String personalidade, String saude) {
        this.id = id;
        this.personalidade = personalidade;
        this.saude = saude;
    }




    public String getSaude() {
        return saude;
    }
    public void setSaude(String saude) {
        this.saude = saude;
    }

    public String getPersonalidade() {
        return personalidade;
    }

    public void setPersonalidade(String personalidade) {
        this.personalidade = personalidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
