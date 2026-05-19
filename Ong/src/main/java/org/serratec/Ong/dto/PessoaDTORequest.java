package org.serratec.Ong.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados para cadastrar uma pessoa")
public class PessoaDTORequest {
     
    
    @Schema(description = "Nome da pessoa", example = "João")
    @NotBlank(message = "O campo 'nome' não pode ficar vazio")
    private String nome;
    
    @Schema(description = "Telefone da pessoa")
    @NotBlank(message = "O campo 'telefone' não pode ficar vazio")
    @Size(max = 11, min = 11, message = "O telefone precisa ter 10 caracteres!")
    @Pattern(regexp = "\\d{11}", message = "O telefone deve conter apenas números")
    private String telefone;
    
    @Schema(description = "CPF da pessoa")
    @NotBlank(message = "O campo 'cpf' não pode ficar vazio")
    @CPF(message = "Informe um CPF válido")
    @Size(max = 11, min = 11, message = "O CPF precisa ter 11 caracteres!")
    private String cpf;
    
    @Schema(description = "Email da pessoa")
    @Email(message = "Informe um email válido")
    private String email;
    
    @Schema(description = "Data de nascimento da pessoa")
    @Past(message = "A data de nascimento precisa estar no passado")
    private LocalDate dataNascimento;
    
    @Schema(description = "ID do endereço cadastrado", example = "1")
    @NotNull(message = "O campo 'idEndereco' não pode ficar vazio")
    private Long idEndereco;
    

    
   
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

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    
}
