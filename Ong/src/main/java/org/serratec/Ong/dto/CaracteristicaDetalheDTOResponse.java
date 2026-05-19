package org.serratec.Ong.dto;

import java.util.List;



public class CaracteristicaDetalheDTOResponse extends CaracteristicaDTOResponse {
    
    private List<AnimalDTOResponse> animal;
    
    
    public CaracteristicaDetalheDTOResponse(){
        
    }

    public CaracteristicaDetalheDTOResponse(Long id, String personalidade, String saude,
            List<AnimalDTOResponse> animal) {
        super(id, personalidade, saude);
        this.animal = animal;
    }

    public List<AnimalDTOResponse> getAnimal() {
        return animal;
    }

    public void setAnimal(List<AnimalDTOResponse> animal) {
        this.animal = animal;
    }

   
    
}
