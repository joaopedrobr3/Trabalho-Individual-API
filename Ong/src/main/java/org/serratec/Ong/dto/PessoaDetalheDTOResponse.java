package org.serratec.Ong.dto;



import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id",
    "nome",
    "telefone",
    "email",
    "dataNascimento",
    "endereco"
})
public class PessoaDetalheDTOResponse extends PessoaDTOResponse {

    private EnderecoDTOResponse endereco;

    public EnderecoDTOResponse getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTOResponse endereco) {
        this.endereco = endereco;
    }
}

