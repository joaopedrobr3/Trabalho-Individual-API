package org.serratec.Ong.dto;



public class InteresseAdocaoDetalheDTOResponse extends InteresseAdocaoDTOResponse{
     
    private PessoaDTOResponse pessoa;
    private AnimalDTOResponse animal;
   
   
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
