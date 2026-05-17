package org.serratec.Ong.dto;

import java.util.List;

public class AnimalDetalheResponse extends AnimalResponse {
    
    private List<CaracteristicaResponse> caracteristica;
    private List<InteresseAdocaoResponse> interesse;
    
    
    public List<CaracteristicaResponse> getCaracteristicas() {
        return caracteristica;
    }
    public void setCaracteristicas(List<CaracteristicaResponse> caracteristicas) {
        this.caracteristica = caracteristicas;
    }
    public List<InteresseAdocaoResponse> getInteresses() {
        return interesse;
    }
    public void setInteresses(List<InteresseAdocaoResponse> interesses) {
        this.interesse = interesses;
    }

    
}
