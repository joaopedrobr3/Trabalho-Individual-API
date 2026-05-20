package org.serratec.Ong.service;

import java.util.List;

import org.serratec.Ong.domain.Animal;
import org.serratec.Ong.domain.Caracteristica;
import org.serratec.Ong.dto.AnimalDTORequest;
import org.serratec.Ong.dto.AnimalDTOResponse;
import org.serratec.Ong.dto.AnimalDetalheDTOResponse;
import org.serratec.Ong.dto.CaracteristicaDTOResponse;
import org.serratec.Ong.dto.InteresseAdocaoDTOResponse;
import org.serratec.Ong.enummerated.Especie;
import org.serratec.Ong.enummerated.Porte;
import org.serratec.Ong.enummerated.Sexo;
import org.serratec.Ong.exception.RecursoNaoEncontradoException;
import org.serratec.Ong.repository.AnimalRepository;
import org.serratec.Ong.repository.CaracteristicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnimalService {
   
    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private CaracteristicaRepository caracteristicaRepository;
    
    @Transactional(readOnly = true)
    public List<AnimalDTOResponse> listar(){
        return animalRepository.findAll()
        .stream()
        .map(this :: toResponse)
        .toList();
    }
    
    @Transactional(readOnly = true)
    public AnimalDetalheDTOResponse buscarPorId(Long id){
    Animal animal = animalRepository.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Animal com o ID digitado não encontrado"));
        
    return toDetalheResponse(animal);
   }
    
    @Transactional
    public AnimalDTOResponse inserir(AnimalDTORequest request){
        Animal animal = new Animal();
        animal.setNome(request.getNome());
        animal.setSexo(Sexo.valueOf(request.getSexo().trim().toUpperCase()));
        animal.setPorte(Porte.valueOf(request.getPorte().trim().toUpperCase()));
        animal.setEspecie(Especie.valueOf(request.getEspecie().trim().toUpperCase()));
        List<Caracteristica> caracteristicas = caracteristicaRepository.findAllById(request.getIdcaracteristica());
        animal.setCaracteristica(caracteristicas);
        
        animalRepository.save(animal);


        return toResponse(animal);
        
    }

    @Transactional
    public AnimalDTOResponse atualizar(Long id, AnimalDTORequest request){
    Animal animal = animalRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Animal não encontrado com o ID digitado"));
        animal.setNome(request.getNome());
        animal.setSexo(Sexo.valueOf(request.getSexo().trim().toUpperCase()));
        animal.setPorte(Porte.valueOf(request.getPorte().trim().toUpperCase()));
        animal.setEspecie(Especie.valueOf(request.getEspecie().trim().toUpperCase()));
        List<Caracteristica> caracteristicas = caracteristicaRepository.findAllById(request.getIdcaracteristica());
        animal.setCaracteristica(caracteristicas);
        animalRepository.save(animal);


        return toResponse(animal); 
    } 
    
    public void deletar(Long id) {
        Animal animal = animalRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Animal não encontrado com o ID digitado"));
        animalRepository.delete(animal);
    }
    
    
    private AnimalDTOResponse toResponse(Animal animal) {
    AnimalDTOResponse response = new AnimalDTOResponse();
    response.setId(animal.getId());
    response.setNome(animal.getNome());
    response.setSexo(animal.getSexo().name());
    response.setPorte(animal.getPorte().name());
    response.setEspecie(animal.getEspecie().name()); 
    
    return response;
}

    private AnimalDetalheDTOResponse toDetalheResponse(Animal animal) {
    AnimalDetalheDTOResponse response = new AnimalDetalheDTOResponse();
    response.setId(animal.getId());
    response.setNome(animal.getNome());
    response.setSexo(animal.getSexo().name());
    response.setPorte(animal.getPorte().name());
    response.setEspecie(animal.getEspecie().name());

   List<CaracteristicaDTOResponse> caracteristicas = animal.getCaracteristica()
    .stream()
    .map(c -> {
        CaracteristicaDTOResponse caracteristica = new CaracteristicaDTOResponse();
        caracteristica.setId(c.getId());
        caracteristica.setPersonalidade(c.getPersonalidade().name());
        caracteristica.setSaude(c.getSaude().name());
        return caracteristica;
    })
    .toList();
    
    response.setCaracteristicas(caracteristicas);

     List<InteresseAdocaoDTOResponse> interesses = animal.getInteresse()
    .stream()
    .map(i -> {
        InteresseAdocaoDTOResponse interesse = new InteresseAdocaoDTOResponse();
        interesse.setId(i.getId());
        interesse.setMotivacao(i.getMotivacao());
        interesse.setTipoMoradia(i.getTipoMoradia().name());
        interesse.setDataSolicitacao(i.getDataSolicitacao());
        
        
        return interesse;
    })
    .toList();
    
    response.setInteresses(interesses);

    return response;
     }
   


}  
