package org.serratec.Ong.domain;

import java.util.List;

import org.serratec.Ong.enummerated.Porte;
import org.serratec.Ong.enummerated.Raca;
import org.serratec.Ong.enummerated.Sexo;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "animal")
public class Animal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", nullable = false)
    private Sexo sexo;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "porte", nullable = false)
    private Porte porte;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "raca", nullable = false)
    private Raca raca;
    
    
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

   public Porte getPorte() {
        return porte;
    }

   public Raca getRaca() {
    return raca;
   }

   public void setRaca(Raca raca) {
    this.raca = raca;
   }
     
}
