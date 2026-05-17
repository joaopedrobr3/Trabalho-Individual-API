package org.serratec.Ong.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "interesse_adocao")
public class InteresseAdocao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Past(message = "O campo 'dataSolicitacao' precisa ser preenchido com uma data passada")
    @NotBlank(message = "O campo 'dataSolicitacao' não pode ficar vazio")
    @Column(name = "data_solicitacao", nullable = false)
    private LocalDate dataSolicitacao;
    
    @NotBlank(message = "O campo 'status' não pode ficar vazio")
    @Column(name = "status", nullable = false)
    private String status;
    
    @NotBlank(message = "O campo motivacao não pode ficar vazio")
    @Size(max = 500, message = "O campo de motivação deve ser preenchido com no máximo 500 caracteres")
    @Column(name = "motivacao", nullable = false, length = 500)
    private String motivacao;
    
    @NotBlank(message = "O campo 'experienciaPrevia' não pode ficar vazio")
    @Column(name = "experiencia_previa", nullable = false)
    private Boolean experienciaPrevia;
    
    @NotBlank(message = "O campo 'tipoMoradia' não pode ficar vazio")
    @Column(name = "tipo_moradia", nullable = false)
    private String tipoMoradia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
