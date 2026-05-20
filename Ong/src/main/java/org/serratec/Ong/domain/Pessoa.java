package org.serratec.Ong.domain;



import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "pessoa")
public class Pessoa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
   
    @Column(name = "nome", nullable = false)
    private String nome;
    
    
    @Column(name = "telefone", nullable = false, length = 11)
    private String telefone;
    
    
    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    private String cpf;
    
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "dataNascimento")
    private LocalDate dataNascimento;
    
    @OneToMany(mappedBy = "pessoa")
    @JsonManagedReference ("pessoa-interesse")
    private List<InteresseAdocao> interesse;
    
    @ManyToOne
    @JoinColumn(name = "id_endereco", nullable = false)  
    @JsonBackReference("pessoa-endereco")
    private Endereco endereco;
    
    
    public Pessoa() {
    }

    public Pessoa(Long id, String nome, String telefone, String cpf, String email, List<InteresseAdocao> interesse,
            Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this.interesse = interesse;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<InteresseAdocao> getInteresse() {
        return interesse;
    }

    public void setInteresse(List<InteresseAdocao> interesse) {
        this.interesse = interesse;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

   

    

    
    
}
