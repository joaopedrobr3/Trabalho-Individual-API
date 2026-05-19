package org.serratec.Ong.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class InteresseAdocaoDTOResponse {
    @JsonPropertyOrder({
        "id",
        "dataSolicitacao",
        "status",
        "motivacao",
        "tipoMoradia"
    })
    
    private Long id;
    private LocalDate dataSolicitacao;
    private String status;
    private String motivacao;
    private String tipoMoradia;
    
    
    public InteresseAdocaoDTOResponse() {
    }

    public InteresseAdocaoDTOResponse(Long id, LocalDate dataSolicitacao, String status, String motivacao,
            String tipoMoradia) {
        this.id = id;
        this.dataSolicitacao = dataSolicitacao;
        this.status = status;
        this.motivacao = motivacao;
        this.tipoMoradia = tipoMoradia;
    }

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
    public String getTipoMoradia() {
        return tipoMoradia;
    }
    public void setTipoMoradia(String tipoMoradia) {
        this.tipoMoradia = tipoMoradia;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    
}
