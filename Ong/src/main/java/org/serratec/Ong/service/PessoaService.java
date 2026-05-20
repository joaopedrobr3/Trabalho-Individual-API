package org.serratec.Ong.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.serratec.Ong.domain.Endereco;
import org.serratec.Ong.domain.Pessoa;
import org.serratec.Ong.dto.EnderecoDTOResponse;
import org.serratec.Ong.dto.PessoaDTORequest;
import org.serratec.Ong.dto.PessoaDTOResponse;
import org.serratec.Ong.dto.PessoaDetalheDTOResponse;
import org.serratec.Ong.exception.RecursoNaoEncontradoException;
import org.serratec.Ong.exception.RecursoRepetidoException;
import org.serratec.Ong.repository.EnderecoRepository;
import org.serratec.Ong.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PessoaService {
   @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;
    
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
public PessoaDTOResponse inserir(PessoaDTORequest request) {

    if (pessoaRepository.existsByCpf(request.getCpf())) {
        throw new RecursoRepetidoException("CPF já cadastrado");
    }
    if (pessoaRepository.existsByEmail(request.getEmail())) {
        throw new RecursoRepetidoException("Email já cadastrado");
    }
    if (pessoaRepository.existsByTelefone(request.getTelefone())) {
        throw new RecursoRepetidoException("Telefone já cadastrado");
    }
    



    
    Endereco endereco = enderecoRepository.findById(request.getIdEndereco())
        .orElseThrow(() -> new RecursoNaoEncontradoException("Endereço não encontrado"));

    Pessoa pessoa = new Pessoa();
    pessoa.setNome(request.getNome());
    pessoa.setCpf(request.getCpf());
    pessoa.setTelefone(request.getTelefone());
    pessoa.setEmail(request.getEmail());
    pessoa.setDataNascimento(request.getDataNascimento());
    pessoa.setEndereco(endereco);

    pessoaRepository.save(pessoa);

    return toResponse(pessoa);
}
    @Transactional
public PessoaDTOResponse atualizar(Long id, PessoaDTORequest request){
    if (pessoaRepository.existsByCpf(request.getCpf())) {
    throw new RecursoRepetidoException("Pessoa já cadastrada");
   }

    Pessoa pessoa = pessoaRepository.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Pessoa não encontrada"));

    Endereco endereco = enderecoRepository.findById(request.getIdEndereco())
        .orElseThrow(() -> new RecursoNaoEncontradoException("Endereço não encontrado"));

  

    pessoa.setNome(request.getNome());
    pessoa.setCpf(request.getCpf());
    pessoa.setEmail(request.getEmail());
    pessoa.setTelefone(request.getTelefone());
    pessoa.setDataNascimento(request.getDataNascimento());
    pessoa.setEndereco(endereco);
    
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

    response.setId(pessoa.getId());
    response.setNome(pessoa.getNome());
    response.setTelefone(pessoa.getTelefone());
    response.setEmail(pessoa.getEmail());
    response.setDataNascimento(pessoa.getDataNascimento());

   

    return response;
}
    
    private PessoaDetalheDTOResponse toDetalheResponse(Pessoa pessoa) {

    PessoaDetalheDTOResponse response = new PessoaDetalheDTOResponse();

    response.setId(pessoa.getId());
    response.setNome(pessoa.getNome());
    response.setEmail(pessoa.getEmail());
    response.setTelefone(pessoa.getTelefone());
    response.setDataNascimento(pessoa.getDataNascimento());

    if (pessoa.getEndereco() != null) {

        EnderecoDTOResponse enderecoResponse = new EnderecoDTOResponse();
        enderecoResponse.setCidade(pessoa.getEndereco().getCidade());
        enderecoResponse.setRua(pessoa.getEndereco().getRua());
        enderecoResponse.setBairro(pessoa.getEndereco().getBairro());
        enderecoResponse.setNumero(pessoa.getEndereco().getNumero());

        response.setEndereco(enderecoResponse);
    }

    return response;
}
    
}
