package org.serratec.Ong.dto;

import java.util.List;



public class AnimalDetalheDTOResponse extends AnimalDTOResponse {
    
    private List<CaracteristicaDTOResponse> caracteristica;
    private List<InteresseAdocaoDTOResponse> interesse;
    
    
    
   
    public AnimalDetalheDTOResponse(Long id, String nome, String sexo, String porte, String especie,
            List<CaracteristicaDTOResponse> caracteristica, List<InteresseAdocaoDTOResponse> interesse) {
        super(id, nome, sexo, porte, especie);
        this.caracteristica = caracteristica;
        this.interesse = interesse;
    }

    public AnimalDetalheDTOResponse() {
        
    }

    public List<CaracteristicaDTOResponse> getCaracteristicas() {
        return caracteristica;
    }
    public void setCaracteristicas(List<CaracteristicaDTOResponse> caracteristicas) {
    this.caracteristica = caracteristicas; 
}
    public List<InteresseAdocaoDTOResponse> getInteresses() {
        return interesse;
    }
    public void setInteresses(List<InteresseAdocaoDTOResponse> interesses) {
        this.interesse = interesses;
    }

    
}
