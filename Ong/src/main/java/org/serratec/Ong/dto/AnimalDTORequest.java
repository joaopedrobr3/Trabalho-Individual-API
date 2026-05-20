package org.serratec.Ong.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Dados para cadastro de um animal")
public class AnimalDTORequest {
    
    @Schema(description = "Nome do animal", example = "Rex")
    @NotBlank(message = "O campo 'nome' não pode ficar vazio")
    private String nome;
    
    @Schema(description = "Gênero do Animal", example = "MACHO")
    @NotBlank(message = "O campo 'sexo' não pode ficar vazio")
    private String sexo;
    
    @Schema(description = "Porte do Animal", example = "GRANDE")
    @NotBlank(message = "O campo 'porte' não pode ficar vazio")
    private String porte;

    @Schema(description = "Especie do Animal", example = "CANINO")
    @NotBlank(message = "O campo 'especie' não pode ficar vazio! Se não tiver uma raça definida, defina como SRD")
    private String especie;

    @Schema(description = "ID das caracteristicas do Animal")
    @NotNull(message = "O campo 'caracteristica' não pode ficar vazio")
    private List<Long> idcaracteristica;
    
    
    
    public AnimalDTORequest(@NotBlank(message = "O campo 'nome' não pode ficar vazio") String nome,
            @NotBlank(message = "O campo 'sexo' não pode ficar vazio") String sexo,
            @NotBlank(message = "O campo 'porte' não pode ficar vazio") String porte,
            @NotBlank(message = "O campo 'especie' não pode ficar vazio! Se não tiver uma raça definida, defina como SRD") String especie,
            @NotNull(message = "O campo 'caracteristica' não pode ficar vazio") List<Long> idcaracteristica) {
        this.nome = nome;
        this.sexo = sexo;
        this.porte = porte;
        this.especie = especie;
        this.idcaracteristica = idcaracteristica;
    }
    
    public String getPorte() {
        return porte;
    }
    public void setPorte(String porte) {
        this.porte = porte;
    }
    
    public List<Long> getIdcaracteristica() {
        return idcaracteristica;
    }
    public void setIdcaracteristica(List<Long> idcaracteristica) {
        this.idcaracteristica = idcaracteristica;
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
