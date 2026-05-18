package org.serratec.Ong.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AnimalRequest {
    
    @NotBlank(message = "O campo 'nome' não pode ficar vazio")
    private String nome;
    @NotBlank(message = "O campo 'sexo' não pode ficar vazio")
    private String sexo;
    @NotBlank(message = "O campo 'porte' não pode ficar vazio")
    private String porte;
    @NotBlank(message = "O campo 'raca' não pode ficar vazio! Se não tiver uma raça definida, defina como SRD")
    private String raca;
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
