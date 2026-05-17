package org.serratec.Ong.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "endereco")
public class Endereco {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O campo 'cidade' não pode ficar vazio")
    @Size(max = 30)
    @Column(name = "cidade", nullable = false)
    private String cidade;
    
    @NotBlank(message = "O campo 'rua' não pode ficar vazio")
    @Size(max = 50)
    @Column(name = "rua", nullable = false)
    private String rua;
    
    @NotBlank(message = "O campo 'bairro' não pode ficar vazio")
    @Size(max = 30)
    @Column(name = "bairro", nullable = false)
    private String bairro;
    
    @Column(name = "numero", nullable = true)
    private Integer numero;
    
    @OneToMany(mappedBy = "endereco")
    @JsonBackReference
    private List<Pessoa> pessoa;

    
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

   

   
}
