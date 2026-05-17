package org.serratec.Ong.dto;



public class InteresseAdocaoDetalheResponse extends InteresseAdocaoResponse{
     
    private PessoaResponse pessoa;
    private AnimalResponse animal;
   
   
    public PessoaResponse getPessoa() {
        return pessoa;
    }
    public void setPessoa(PessoaResponse pessoa) {
        this.pessoa = pessoa;
    }
    public AnimalResponse getAnimal() {
        return animal;
    }
    public void setAnimal(AnimalResponse animal) {
        this.animal = animal;
    }
    
   

    
}
