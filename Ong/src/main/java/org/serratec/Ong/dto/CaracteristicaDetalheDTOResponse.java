package org.serratec.Ong.dto;

import java.util.List;



public class CaracteristicaDetalheDTOResponse extends CaracteristicaDTOResponse {
    
    private List<AnimalDTOResponse> animal;

    public List<AnimalDTOResponse> getAnimal() {
        return animal;
    }

    public void setAnimal(List<AnimalDTOResponse> animal) {
        this.animal = animal;
    }

   
    
}
