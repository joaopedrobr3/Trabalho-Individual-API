package org.serratec.Ong.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Caracteristicas de um Animal")
public class CaracteristicaRequest {
    

    @Schema(description = "Personalidade do animal", example = "AMIGAVEL")
    @NotBlank(message = "O campo 'personalidade' não pode ser vazio")
    private String personalidade;
    
    @Schema(description = "Estado de saúde do animal", example = "JOVEM_SAUDAVEL")
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
