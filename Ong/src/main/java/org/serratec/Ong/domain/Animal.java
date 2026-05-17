package org.serratec.Ong.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "animal")
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O campo 'especie' não pode ficar vazio")
    @Column( name = "especie", nullable = false)
    private String especie;
    
    @NotBlank(message = "O campo 'porte' não pode ficar vazio")
    @Column(name = "porte", nullable = false)
    private String porte;
    
    @NotBlank(message = "O campo 'raca' não pode ficar vazio! Se não tiver uma raça definida, defina como SRD")
    @Column(name = "raca", nullable = false)
    private String raca;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

     
}
