package org.serratec.Ong.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados de endereço")
public class EnderecoRequest {
    
    @Schema(description = "Nome da cidade", example = "Petrópolis")
    @NotBlank(message = "O campo 'cidade' não pode ficar vazio")
    @Size(max = 30)
    private String cidade;
    
    @Schema(description = "Nome da rua", example = "Rua do Imperador ")
    @NotBlank(message = "O campo 'rua' não pode ficar vazio")
    @Size(max = 50)
    private String rua;
    
    @Schema(description = "Nome do bairro", example = "Bingen")
    @NotBlank(message = "O campo 'bairro' não pode ficar vazio")
    @Size(max = 30)
    private String bairro;
    
    @Schema(description = "Número da casa", example = "178")
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
