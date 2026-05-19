package org.serratec.Ong.service;


import java.util.List;


import org.serratec.Ong.domain.Endereco;
import org.springframework.transaction.annotation.Transactional;
import org.serratec.Ong.dto.EnderecoDTORequest;
import org.serratec.Ong.dto.EnderecoDTOResponse;
import org.serratec.Ong.exception.RecursoNaoEncontradoException;
import org.serratec.Ong.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EnderecoService {
     
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional(readOnly = true)
    public List<EnderecoDTOResponse> listar(){
        return enderecoRepository.findAll()
        .stream()
        .map(this :: toResponse)
        .toList();
    }

    @Transactional(readOnly = true)
    public EnderecoDTOResponse buscarPorId(Long id){
        Endereco endereco = enderecoRepository.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoException("O endereco com o ID digitado não encontrado"));
       return toResponse(endereco);
    } 

    @Transactional
    public EnderecoDTOResponse inserir(EnderecoDTORequest request){
        Endereco endereco = new Endereco();
        endereco.setCidade(request.getCidade()); 
        endereco.setBairro(request.getBairro());
        endereco.setRua(request.getRua());  
        endereco.setNumero(request.getNumero()); 
        return toResponse(endereco);
        
    }

    

    private EnderecoDTOResponse toResponse(Endereco endereco) {
    EnderecoDTOResponse response = new EnderecoDTOResponse();
    response.setId(endereco.getId());
    response.setCidade(endereco.getCidade()); 
    response.setBairro(endereco.getBairro());
    response.setRua(endereco.getRua());  
    response.setNumero(endereco.getNumero());                  
    return response;
    }
}
