package org.serratec.Ong.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class EnderecoRequest {
    
    @NotBlank(message = "O campo 'cidade' não pode ficar vazio")
    @Size(max = 30)
    private String cidade;
    
    @NotBlank(message = "O campo 'rua' não pode ficar vazio")
    @Size(max = 50)
    private String rua;
    
    @NotBlank(message = "O campo 'bairro' não pode ficar vazio")
    @Size(max = 30)
    private String bairro;
    
    @Positive(message = "O número precisa ser positivo")
    private Integer numero;

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

    
}
