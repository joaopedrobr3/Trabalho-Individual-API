package org.serratec.Ong.controller;



import java.util.List;

import org.serratec.Ong.dto.PessoaDTORequest;
import org.serratec.Ong.dto.PessoaDTOResponse;
import org.serratec.Ong.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
@Autowired
    private PessoaService pessoaService;

    @GetMapping
    @Operation(summary = "Lista todas as pessoas", description = "Retorna uma lista com todas as pessoas cadastradas")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Pessoas encontradas"),
    })
    public ResponseEntity<List<PessoaDTOResponse>> listar() {
        return ResponseEntity.ok(pessoaService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca pessoa por ID", description = "Retorna os detalhes de um pessoa pelo ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Pessoa encontrada", content = @Content),
    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada com o ID informado", content = @Content)
    })
    public ResponseEntity<PessoaDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.buscarPorId(id));
    }
    
    @PostMapping
    @Operation(summary = "Cadastra um pessoa", description = "Cria um novo pessoa no sistema")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Pessoa cadastrada com sucesso", content = @Content),
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou campos obrigatórios vazios", content = @Content),
    @ApiResponse(responseCode = "409", description = "Pessoa já cadastrada no sistema", content = @Content)
})
    public ResponseEntity<PessoaDTOResponse> inserir(@RequestBody @Valid PessoaDTORequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.inserir(request));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um pessoa", description = "Atualiza os dados de um pessoa existente")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso", content = @Content),
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou campos obrigatórios vazios", content = @Content),
    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada com o ID informado", content = @Content)
})
    public ResponseEntity<PessoaDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid PessoaDTORequest request) {
        return ResponseEntity.ok(pessoaService.atualizar(id, request));
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um pessoa", description = "Remove um pessoa pelo ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Pessoa removida com sucesso", content = @Content),
    @ApiResponse(responseCode = "404", description = "Pessoa não encontrada com o ID informado", content = @Content)
})
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();}
}

