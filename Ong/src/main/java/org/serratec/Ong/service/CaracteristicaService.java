package org.serratec.Ong.service;

import java.util.List;


import org.serratec.Ong.domain.Caracteristica;
import org.serratec.Ong.dto.AnimalDTOResponse;
import org.serratec.Ong.dto.CaracteristicaDTORequest;
import org.serratec.Ong.dto.CaracteristicaDTOResponse;
import org.serratec.Ong.dto.CaracteristicaDetalheDTOResponse;
import org.serratec.Ong.enummerated.Personalidade;
import org.serratec.Ong.enummerated.Saude;
import org.serratec.Ong.exception.RecursoNaoEncontradoException;
import org.serratec.Ong.repository.CaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CaracteristicaService {
    
    @Autowired
    private CaracteristicaRepository caracteristicaRepository;
    
    @Transactional(readOnly = true)
    public List<CaracteristicaDTOResponse> listar(){
        return caracteristicaRepository.findAll()
        .stream()
        .map(this :: toResponse)
        .toList();
    }

    @Transactional(readOnly = true)
    public CaracteristicaDetalheDTOResponse buscarPorId(Long id){
    Caracteristica caracteristica = caracteristicaRepository.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Caracteristica com o ID digitado não encontrada"));
        
    return toDetalheResponse(caracteristica);
    }

    @Transactional
    public CaracteristicaDTOResponse inserir(CaracteristicaDTORequest request){
        Caracteristica caracteristica = new Caracteristica();
        caracteristica.setPersonalidade(Personalidade.valueOf(request.getPersonalidade().trim().toUpperCase()));
        caracteristica.setSaude(Saude.valueOf(request.getSaude().trim().toUpperCase()));
        caracteristicaRepository.save(caracteristica);

        return toResponse(caracteristica);
        
    }
    @Transactional
    public CaracteristicaDTOResponse atualizar(Long id, CaracteristicaDTORequest request){
        Caracteristica caracteristica = caracteristicaRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Caracteristica não encontrada com o ID digitado"));
        caracteristica.setPersonalidade(Personalidade.valueOf(request.getPersonalidade().trim().toUpperCase()));
        caracteristica.setSaude(Saude.valueOf(request.getSaude().trim().toUpperCase()));
        caracteristicaRepository.save(caracteristica);

        return toResponse(caracteristica); 
    }

    public void deletar(Long id) {
        Caracteristica caracteristica = caracteristicaRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Caracteristica não encontrada com o ID digitado"));
        caracteristicaRepository.delete(caracteristica);
    }
    
    private CaracteristicaDTOResponse toResponse(Caracteristica caracteristica) {
    CaracteristicaDTOResponse response = new CaracteristicaDTOResponse();
    response.setId(caracteristica.getId());
    response.setPersonalidade(caracteristica.getPersonalidade().name().trim().toUpperCase()); 
    response.setSaude(caracteristica.getSaude().name().trim().toUpperCase());
    
    
    return response;
    }
    
    private CaracteristicaDetalheDTOResponse toDetalheResponse(Caracteristica caracteristica) {
    CaracteristicaDetalheDTOResponse response = new CaracteristicaDetalheDTOResponse();
    response.setId(caracteristica.getId());
    response.setPersonalidade(caracteristica.getPersonalidade().name());
    response.setSaude(caracteristica.getSaude().name());
    List<AnimalDTOResponse> animais = caracteristica.getAnimal()
        .stream()
        .map(animal -> new AnimalDTOResponse(
            animal.getId(),
            animal.getNome(),
            animal.getSexo().name(),    
            animal.getPorte().name(),   
            animal.getEspecie().name()  
        ))
        .toList();

    response.setAnimal(animais);

    return response;
}
}
