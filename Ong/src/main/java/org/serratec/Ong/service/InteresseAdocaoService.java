package org.serratec.Ong.service;


import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.serratec.Ong.domain.Animal;
import org.serratec.Ong.domain.InteresseAdocao;
import org.serratec.Ong.domain.Pessoa;
import org.serratec.Ong.dto.AnimalDTOResponse;
import org.serratec.Ong.dto.InteresseAdocaoDTORequest;
import org.serratec.Ong.dto.InteresseAdocaoDTOResponse;
import org.serratec.Ong.dto.InteresseAdocaoDetalheDTOResponse;
import org.serratec.Ong.dto.PessoaDTOResponse;
import org.serratec.Ong.enummerated.TipoMoradia;
import org.serratec.Ong.exception.RecursoNaoEncontradoException;
import org.serratec.Ong.exception.RecursoRepetidoException;
import org.serratec.Ong.repository.AnimalRepository;
import org.serratec.Ong.repository.InteresseAdocaoRepository;
import org.serratec.Ong.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class InteresseAdocaoService {
   @Autowired
    private InteresseAdocaoRepository interesseAdocaoRepository;
   @Autowired
    private PessoaRepository pessoaRepository;
   @Autowired
    private AnimalRepository animalRepository;
    
    @Transactional(readOnly = true)
    public List<InteresseAdocaoDTOResponse> listar(){
        return interesseAdocaoRepository.findAll()
        .stream()
        .map(this :: toResponse)
        .toList();
}
    
    @Transactional(readOnly = true)
    public InteresseAdocaoDetalheDTOResponse buscarPorId(Long id){
    InteresseAdocao ia = interesseAdocaoRepository.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Interesse com o ID digitado não encontrado"));
        
    return toDetalheResponse(ia);
   }
    
    @Transactional
    public InteresseAdocaoDTOResponse inserir(InteresseAdocaoDTORequest request) {
        Pessoa pessoa = pessoaRepository.findById(request.getIdPessoa())
            .orElseThrow(() -> new RecursoNaoEncontradoException("Pessoa não encontrada com ID digitado"));
       Animal animal = animalRepository.findById(request.getIdAnimal())
            .orElseThrow(() -> new RecursoNaoEncontradoException("Animal não encontrado com ID digitado"));

        if (interesseAdocaoRepository.existsByPessoaIdAndAnimalId(request.getIdPessoa(), request.getIdAnimal())) {
            throw new RecursoRepetidoException("Essa pessoa já demonstrou interesse nesse animal!");
        }

        InteresseAdocao ia = new InteresseAdocao();
        ia.setMotivacao(request.getMotivacao());
        ia.setTipoMoradia(TipoMoradia.valueOf(request.getTipoMoradia().trim().toUpperCase()));
        ia.setPessoa(pessoa);
        ia.setAnimal(animal);

        interesseAdocaoRepository.save(ia);
        return toResponse(ia);
    }

    @Transactional
    public InteresseAdocaoDTOResponse atualizar(Long id, InteresseAdocaoDTORequest request) {
        InteresseAdocao ia = interesseAdocaoRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Interesse não encontrado com id: " + id));
        Pessoa pessoa = pessoaRepository.findById(request.getIdPessoa())
            .orElseThrow(() -> new RecursoNaoEncontradoException("Pessoa não encontrada com ID digitado"));
        Animal animal = animalRepository.findById(request.getIdAnimal())
            .orElseThrow(() -> new RecursoNaoEncontradoException("Animal não encontrado com ID digitado"));

        
        ia.setMotivacao(request.getMotivacao());
        ia.setTipoMoradia(TipoMoradia.valueOf(request.getTipoMoradia().trim().toUpperCase()));
        ia.setPessoa(pessoa);
        ia.setAnimal(animal);

        interesseAdocaoRepository.save(ia);
        return toResponse(ia);
}

    public void deletar(Long id) {
        InteresseAdocao ia = interesseAdocaoRepository.findById(id)
            .orElseThrow(() -> new RecursoNaoEncontradoException("Interesse não encontrado com o ID digitado"));
        interesseAdocaoRepository.delete(ia);
    }
    
    
    private InteresseAdocaoDTOResponse toResponse(InteresseAdocao interesseAdocao) {
    InteresseAdocaoDTOResponse response = new InteresseAdocaoDTOResponse();
    response.setId(interesseAdocao.getId());
    response.setDataSolicitacao(interesseAdocao.getDataSolicitacao());
    response.setMotivacao(interesseAdocao.getMotivacao());
    response.setTipoMoradia(interesseAdocao.getTipoMoradia().name()); 
    
    return response;
}

    private InteresseAdocaoDetalheDTOResponse toDetalheResponse(InteresseAdocao interesse) {

    InteresseAdocaoDetalheDTOResponse response = new InteresseAdocaoDetalheDTOResponse();

    response.setId(interesse.getId());
    response.setDataSolicitacao(interesse.getDataSolicitacao());
    response.setMotivacao(interesse.getMotivacao());
    response.setTipoMoradia(interesse.getTipoMoradia().name().trim().toUpperCase());

    PessoaDTOResponse pessoaResponse = new PessoaDTOResponse();
    pessoaResponse.setId(interesse.getPessoa().getId());
    pessoaResponse.setNome(interesse.getPessoa().getNome());
    pessoaResponse.setEmail(interesse.getPessoa().getEmail());
    pessoaResponse.setTelefone(interesse.getPessoa().getTelefone());
    pessoaResponse.setDataNascimento(interesse.getPessoa().getDataNascimento());
    response.setPessoa(pessoaResponse);

    AnimalDTOResponse animalResponse = new AnimalDTOResponse();
    animalResponse.setId(interesse.getAnimal().getId());
    animalResponse.setNome(interesse.getAnimal().getNome());
    animalResponse.setEspecie(interesse.getAnimal().getEspecie().name().trim().toUpperCase());
    animalResponse.setSexo(interesse.getAnimal().getSexo().name().trim().toUpperCase());
    animalResponse.setPorte(interesse.getAnimal().getPorte().name().trim().toUpperCase());

    response.setAnimal(animalResponse);

    return response;
}

}
