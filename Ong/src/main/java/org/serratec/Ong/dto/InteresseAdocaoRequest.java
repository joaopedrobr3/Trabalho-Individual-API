package org.serratec.Ong.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados para cadastrar uma solicitação de adoção")
public class InteresseAdocaoRequest {
    
    @Schema(description = "Data da solicitação de interesse")
    @Past(message = "A data precisa estar no passado")
    @NotNull(message = "O campo 'dataSolicitacao' não pode ficar vazio")
    private LocalDate dataSolicitacao;
    
    @Schema(description = "Status da solicitação", example = "APROVADO")
    @NotBlank(message = "O campo 'status' não pode ficar vazio")
    private String status;
    
    @Schema(description = "Motivação da adoção", example = "Presente para o filho")
    @NotBlank(message = "O campo motivacao não pode ficar vazio")
    @Size(max = 500, message = "O campo de motivação deve ser preenchido com no máximo 500 caracteres")
    private String motivacao;
    
    @Schema(description = "Experiência prévia com animais", example = "True")
    @NotNull(message = "O campo 'experienciaPrevia' não pode ficar vazio")
    private Boolean experienciaPrevia;
    
    @Schema(description = "Tipo de lugar que a pessoa mora", example = "CASA")
    @NotBlank(message = "O campo 'tipoMoradia' não pode ficar vazio")
    private String tipoMoradia;
    
    @Schema(description = "ID de cadastro da pessoa interessada", example = "1")
    @NotNull(message = "O campo 'idPessoa' não pode ficar vazio")
    private Long idPessoa;
    
    @Schema(description = "ID de cadastro do animal de interesse", example = "1")
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
