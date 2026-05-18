package org.serratec.Ong.dto;

import java.time.LocalDate;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class InteresseAdocaoRequest {
    
    @Past(message = "A data precisa estar no passado")
    @NotNull(message = "O campo 'dataSolicitacao' não pode ficar vazio")
    private LocalDate dataSolicitacao;
    
    @NotBlank(message = "O campo 'status' não pode ficar vazio")
    private String status;
    
    @NotBlank(message = "O campo motivacao não pode ficar vazio")
    @Size(max = 500, message = "O campo de motivação deve ser preenchido com no máximo 500 caracteres")
    private String motivacao;
    
    @NotNull(message = "O campo 'experienciaPrevia' não pode ficar vazio")
    private Boolean experienciaPrevia;
    
    @NotBlank(message = "O campo 'tipoMoradia' não pode ficar vazio")
    private String tipoMoradia;

    @NotNull(message = "O campo 'idPessoa' não pode ficar vazio")
    private Long idPessoa;

    @NotNull(message = "O campo 'idAnimal' não pode ficar vazio")
    private Long idAnimal;

    
    public LocalDate getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDate dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(String motivacao) {
        this.motivacao = motivacao;
    }

    public Boolean getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(Boolean experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }

    public String getTipoMoradia() {
        return tipoMoradia;
    }

    public void setTipoMoradia(String tipoMoradia) {
        this.tipoMoradia = tipoMoradia;
    }

    
}
