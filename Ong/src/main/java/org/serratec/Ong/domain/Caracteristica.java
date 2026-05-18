package org.serratec.Ong.domain;

import java.util.List;

import org.serratec.Ong.enummerated.Personalidade;
import org.serratec.Ong.enummerated.Saude;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "caracteristica")
public class Caracteristica {
     
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @Enumerated(EnumType.STRING)
    @Column(name = "personalidade", nullable = false)
    private Personalidade personalidade;
    

    @Enumerated(EnumType.STRING)
    @Column(name = "saude", nullable = false)
    private Saude saude;
    
    
    @ManyToMany(mappedBy = "caracteristica")
    @JsonBackReference
    private List<Animal> animal;
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

    public Personalidade getPersonalidade() {
        return personalidade;
    }

    public void setPersonalidade(Personalidade personalidade) {
        this.personalidade = personalidade;
    }

    public Saude getSaude() {
        return saude;
    }

    public void setSaude(Saude saude) {
        this.saude = saude;
    }

   
    
    
    
}
