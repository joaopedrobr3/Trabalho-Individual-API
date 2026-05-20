package org.serratec.Ong.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.serratec.Ong.domain.Pessoa;
import org.serratec.Ong.dto.EnderecoDTOResponse;
import org.serratec.Ong.dto.PessoaDTORequest;
import org.serratec.Ong.dto.PessoaDTOResponse;
import org.serratec.Ong.dto.PessoaDetalheDTOResponse;
import org.serratec.Ong.exception.RecursoNaoEncontradoException;
import org.serratec.Ong.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PessoaService {
   @Autowired
    private PessoaRepository pessoaRepository;
    
    @Transactional(readOnly = true)
    public List<PessoaDTOResponse> listar(){
        return pessoaRepository.findAll()
        .stream()
        .map(this :: toResponse)
        .toList();
    }

    @Transactional(readOnly = true)
    public PessoaDetalheDTOResponse buscarPorId(Long id){
    Pessoa pessoa = pessoaRepository.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Pessoa com o ID digitado não encontrada"));
        
    return toDetalheResponse(pessoa);
    }

    @Transactional
    public PessoaDTOResponse inserir(PessoaDTORequest request){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(pessoa.getId());
        pessoa.setNome(pessoa.getNome());
       pessoa.setEmail(pessoa.getEmail());
        pessoa.setTelefone(pessoa.getTelefone());
        pessoaRepository.save(pessoa);

        return toResponse(pessoa);
        
    }
    @Transactional
    public PessoaDTOResponse atualizar(Long id, PessoaDTORequest request){
        Pessoa pessoa = pessoaRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Pessoa não encontrada com o ID digitado"));
        pessoa.setId(pessoa.getId());
        pessoa.setNome(pessoa.getNome());
        pessoa.setEmail(pessoa.getEmail());
        pessoa.setTelefone(pessoa.getTelefone());
        pessoa.setDataNascimento(pessoa.getDataNascimento());
        pessoa.setEndereco(pessoa.getEndereco());
        pessoaRepository.save(pessoa);

        return toResponse(pessoa); 
    }

    public void deletar(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Pessoa não encontrada com o ID digitado"));
        pessoaRepository.delete(pessoa);
    }
    
    private PessoaDTOResponse toResponse(Pessoa pessoa) {
    PessoaDTOResponse response = new PessoaDTOResponse();
    pessoa.setId(pessoa.getId());
        pessoa.setNome(pessoa.getNome());
        pessoa.setEmail(pessoa.getEmail());
        pessoa.setTelefone(pessoa.getTelefone());
        pessoa.setDataNascimento(pessoa.getDataNascimento());
       
    
    
    return response;
    }
    
    private PessoaDetalheDTOResponse toDetalheResponse(Pessoa pessoa) {
    PessoaDetalheDTOResponse response = new PessoaDetalheDTOResponse();

   
    response.setId(pessoa.getId());
    response.setNome(pessoa.getNome());
    response.setEmail(pessoa.getEmail());
    response.setTelefone(pessoa.getTelefone());

    
    EnderecoDTOResponse enderecoResponse = new EnderecoDTOResponse();
    enderecoResponse.setId(pessoa.getEndereco().getId());
    enderecoResponse.setCidade(pessoa.getEndereco().getCidade());
    enderecoResponse.setRua(pessoa.getEndereco().getRua());
    enderecoResponse.setBairro(pessoa.getEndereco().getBairro());
    enderecoResponse.setNumero(pessoa.getEndereco().getNumero());
    response.setEndereco(enderecoResponse);

   
    return response;
}
    
}
