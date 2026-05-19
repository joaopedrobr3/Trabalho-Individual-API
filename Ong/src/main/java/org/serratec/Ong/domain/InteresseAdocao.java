package org.serratec.Ong.domain;


import java.time.LocalDate;


import org.serratec.Ong.enummerated.TipoMoradia;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "interesse_adocao")
public class InteresseAdocao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    
    @Column(name = "data_solicitacao", nullable = false)
    private LocalDate dataSolicitacao;
    
   
    @Column(name = "motivacao", nullable = false, length = 500)
    private String motivacao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_moradia", nullable = false)
    private TipoMoradia tipoMoradia;
    
    @ManyToOne
    @JoinColumn(name = "id_pessoa")
    @JsonBackReference ("pessoa-interesse")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "id_animal")
    @JsonBackReference ("animal-interesse")
    private Animal animal;
    
    
    
    
    public InteresseAdocao() {
    }

    public InteresseAdocao(Long id, LocalDate dataSolicitacao, String motivacao,
            TipoMoradia tipoMoradia, Pessoa pessoa, Animal animal) {
        this.id = id;
        this.dataSolicitacao = dataSolicitacao;
        this.motivacao = motivacao;
        this.tipoMoradia = tipoMoradia;
        this.pessoa = pessoa;
        this.animal = animal;
    }

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


    public String getMotivacao() {
        return motivacao;
    }

    public void setMotivacao(String motivacao) {
        this.motivacao = motivacao;
    }


    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public TipoMoradia getTipoMoradia() {
        return tipoMoradia;
    }

    public void setTipoMoradia(TipoMoradia tipoMoradia) {
        this.tipoMoradia = tipoMoradia;
    }


   
    

}
