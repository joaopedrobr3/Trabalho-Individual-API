package org.serratec.Ong.dto;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados para cadastrar uma solicitação de adoção")
public class InteresseAdocaoDTORequest {
    
    @Schema(description = "Data da solicitação de interesse")
    @NotNull(message = "O campo 'dataSolicitacao' não pode ficar vazio")
    private LocalDate dataSolicitacao;
    
    @Schema(description = "Motivação da adoção", example = "Presente para o filho")
    @NotBlank(message = "O campo motivacao não pode ficar vazio")
    @Size(max = 500, message = "O campo de motivação deve ser preenchido com no máximo 500 caracteres")
    private String motivacao;
    
    @Schema(description = "Tipo de lugar que a pessoa mora", example = "CASA")
    @NotBlank(message = "O campo 'tipoMoradia' não pode ficar vazio")
    private String tipoMoradia;
    
    @Schema(description = "Status da solicitação", example = "PENDENTE")
    @NotBlank(message = "O campo 'status' não pode ficar vazio")
    private String status;
    
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

    public String getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(String motivacao) {
        this.motivacao = motivacao;
    }

    public String getTipoMoradia() {
        return tipoMoradia;
    }

    public void setTipoMoradia(String tipoMoradia) {
        this.tipoMoradia = tipoMoradia;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }
    
    
    
}
