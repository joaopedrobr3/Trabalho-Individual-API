package org.serratec.Ong.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id",
    "dataSolicitacao",
    "motivacao",
    "tipoMoradia",
    "status",
    "pessoa",
    "animal"
})

public class InteresseAdocaoDTOResponse {
    
    private Long id;
    private LocalDate dataSolicitacao;
    private String motivacao;
    private String tipoMoradia;
    private String status;
    private PessoaDTOResponse pessoa;
    private AnimalDTOResponse animal;
    
    
    public InteresseAdocaoDTOResponse() {
    }

    

public InteresseAdocaoDTOResponse(Long id, LocalDate dataSolicitacao, String motivacao, String tipoMoradia,
            String status, PessoaDTOResponse pessoa, AnimalDTOResponse animal) {
        this.id = id;
        this.dataSolicitacao = dataSolicitacao;
        this.motivacao = motivacao;
        this.tipoMoradia = tipoMoradia;
        this.status = status;
        this.pessoa = pessoa;
        this.animal = animal;
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

public PessoaDTOResponse getPessoa() {
        return pessoa;
    }


public void setPessoa(PessoaDTOResponse pessoa) {
        this.pessoa = pessoa;
    }

public AnimalDTOResponse getAnimal() {
        return animal;
    }



public void setAnimal(AnimalDTOResponse animal) {
        this.animal = animal;
    }


public String getStatus() {
        return status;
    }




public void setStatus(String status) {
        this.status = status;
    }

}
