package org.serratec.Ong.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Dados para cadastro de um animal")
public class AnimalRequest {
    
    @Schema(description = "Nome do animal", example = "Rex")
    @NotBlank(message = "O campo 'nome' não pode ficar vazio")
    private String nome;
    
    @Schema(description = "Gênero do Animal", example = "MACHO")
    @NotBlank(message = "O campo 'sexo' não pode ficar vazio")
    private String sexo;
    
    @Schema(description = "Porte do Animal", example = "GRANDE")
    @NotBlank(message = "O campo 'porte' não pode ficar vazio")
    private String porte;

    @Schema(description = "Raça do Animal", example = "PASTOR_ALEMAO")
    @NotBlank(message = "O campo 'raca' não pode ficar vazio! Se não tiver uma raça definida, defina como SRD")
    private String raca;

    @Schema(description = "ID das caracteristicas do Animal", example = "1")
    @NotNull(message = "O campo 'caracteristica' não pode ficar vazio")
    private List<Long> idcaracteristica;
    
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

    


}
