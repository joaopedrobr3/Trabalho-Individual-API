package org.serratec.Ong.dto;



public class PessoaDetalheDTOResponse extends PessoaDTOResponse {
    private EnderecoDTOResponse endereco;
   

    public EnderecoDTOResponse getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTOResponse endereco) {
        this.endereco = endereco;
    }

    
}

