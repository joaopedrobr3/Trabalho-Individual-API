package org.serratec.Ong.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
    
    
    @OneToMany(mappedBy = "animal")
    @JsonManagedReference ("animal-interesse")
    private List<InteresseAdocao> interesse;


    @ManyToMany
    @JoinTable(
    name = "animal_caracteristica",
    joinColumns = @JoinColumn(name = "id_animal"),
    inverseJoinColumns = @JoinColumn(name = "id_caracteristica")
    )
    @JsonManagedReference
    private List<Caracteristica> caracteristica;
    

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

    

    public List<Caracteristica> getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(List<Caracteristica> caracteristica) {
        this.caracteristica = caracteristica;
    }

    public List<InteresseAdocao> getInteresse() {
        return interesse;
    }

    public void setInteresse(List<InteresseAdocao> interesse) {
        this.interesse = interesse;
    }

   

     
}
