package org.serratec.Ong.dto;

import java.util.List;



public class CaracteristicaDetalheResponse extends CaracteristicaResponse {
    
    private List<AnimalResponse> animal;

    public List<AnimalResponse> getAnimal() {
        return animal;
    }

    public void setAnimal(List<AnimalResponse> animal) {
        this.animal = animal;
    }

   
    
}
