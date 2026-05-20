package org.serratec.Ong.controller;

import java.util.List;


import org.serratec.Ong.dto.EnderecoDTORequest;
import org.serratec.Ong.dto.EnderecoDTOResponse;
import org.serratec.Ong.service.EnderecoService;
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
@RequestMapping("/enderecos")
public class EnderecoController {
     @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    @Operation(summary = "Lista todos os endereços", description = "Retorna uma lista com todos os endereços cadastrados")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Animais encontrados"),
    })
    public ResponseEntity<List<EnderecoDTOResponse>> listar() {
        return ResponseEntity.ok(enderecoService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca endereço por ID", description = "Retorna os detalhes de um endereço pelo ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Endereço encontrado", content = @Content),
    @ApiResponse(responseCode = "404", description = "Endereço não encontrado com o ID informado", content = @Content)
    })
    public ResponseEntity<EnderecoDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.buscarPorId(id));
    }
    
    @PostMapping
    @Operation(summary = "Cadastra um endereço", description = "Cria um novo endereço no sistema")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Endereço cadastrado com sucesso", content = @Content),
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou campos obrigatórios vazios", content = @Content),
    @ApiResponse(responseCode = "409", description = "Endereço já cadastrado no sistema", content = @Content)
})
    public ResponseEntity<EnderecoDTOResponse> inserir(@RequestBody @Valid EnderecoDTORequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.inserir(request));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um endereço", description = "Atualiza os dados de um endereço existente")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Endereço atualizado com sucesso", content = @Content),
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou campos obrigatórios vazios", content = @Content),
    @ApiResponse(responseCode = "404", description = "Endereço não encontrado com o ID informado", content = @Content)
})
    public ResponseEntity<EnderecoDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid EnderecoDTORequest request) {
        return ResponseEntity.ok(enderecoService.atualizar(id, request));
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um endereço", description = "Remove um endereço pelo ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Endereço removido com sucesso", content = @Content),
    @ApiResponse(responseCode = "404", description = "Endereço não encontrado com o ID informado", content = @Content)
})
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();}
}
