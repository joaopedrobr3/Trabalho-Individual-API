package org.serratec.Ong.domain;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco")
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "cidade", nullable = false)
    private String cidade;
    
    @Column(name = "rua", nullable = false)
    private String rua;
    
    @Column(name = "bairro", nullable = false)
    private String bairro;
    
    @Column(name = "numero", nullable = true)
    private Integer numero;
    
    @OneToMany(mappedBy = "endereco")
    @JsonManagedReference("pessoa-endereco")
    private List<Pessoa> pessoa;
    
    
    
    public Endereco() {
    }

    public Endereco(Long id, String cidade, String rua, String bairro, Integer numero, List<Pessoa> pessoa) {
        this.id = id;
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
        this.pessoa = pessoa;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<Pessoa> getPessoa() {
        return pessoa;
    }

    public void setPessoa(List<Pessoa> pessoa) {
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   

   
}
