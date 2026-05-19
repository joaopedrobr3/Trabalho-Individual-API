package org.serratec.Ong.dto;

import java.time.LocalDate;

public class InteresseAdocaoDetalheDTOResponse extends InteresseAdocaoDTOResponse{
     
    private PessoaDTOResponse pessoa;
    private AnimalDTOResponse animal;
   
    
    
    
    public InteresseAdocaoDetalheDTOResponse() {
        
    }

    public InteresseAdocaoDetalheDTOResponse(Long id, LocalDate dataSolicitacao, String motivacao, String tipoMoradia,
            PessoaDTOResponse pessoa, AnimalDTOResponse animal) {
        super(id, dataSolicitacao, motivacao, tipoMoradia);
        this.pessoa = pessoa;
        this.animal = animal;
    }
    
    public PessoaDTOResponse getPessoa() {
        return pessoa;
    }
    public void setPessoa(PessoaDTOResponse pessoa) {
        this.pessoa = pessoa;
    }
    public AnimalDTOResponse getAnimal() {
        return animal;
    }
    public void setAnimal(AnimalDTOResponse animal) {
        this.animal = animal;
    }
    
   

    
}
