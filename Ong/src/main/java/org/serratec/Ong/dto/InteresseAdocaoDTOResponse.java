package org.serratec.Ong.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id",
    "dataSolicitacao",
    "motivacao",
    "tipoMoradia"
})
public class InteresseAdocaoDTOResponse {
    
    private Long id;
    private LocalDate dataSolicitacao;
    private String motivacao;
    private String tipoMoradia;
    
    
    public InteresseAdocaoDTOResponse() {
    }

    public InteresseAdocaoDTOResponse(Long id, LocalDate dataSolicitacao,  String motivacao,
            String tipoMoradia) {
        this.id = id;
        this.dataSolicitacao = dataSolicitacao;
        this.motivacao = motivacao;
        this.tipoMoradia = tipoMoradia;
    }

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
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    
}
