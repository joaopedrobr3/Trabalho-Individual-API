package org.serratec.Ong.controller;

import java.util.List;

import org.serratec.Ong.dto.AnimalDTORequest;
import org.serratec.Ong.dto.AnimalDTOResponse;
import org.serratec.Ong.dto.EnderecoDTORequest;
import org.serratec.Ong.dto.EnderecoDTOResponse;
import org.serratec.Ong.service.AnimalService;
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
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
     @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    @Operation(summary = "Lista todos os animais", description = "Retorna uma lista com todos os animais cadastrados")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Animais encontrados"),
    })
    public ResponseEntity<List<EnderecoDTOResponse>> listar() {
        return ResponseEntity.ok(enderecoService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca endereco por ID", description = "Retorna os detalhes de um endereco pelo ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "endereco encontrado", content = @Content),
    @ApiResponse(responseCode = "404", description = "endereco não encontrado com o ID informado", content = @Content)
    })
    public ResponseEntity<EnderecoDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.buscarPorId(id));
    }
    
    @PostMapping
    @Operation(summary = "Cadastra um endereco", description = "Cria um novo endereco no sistema")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "endereco cadastrado com sucesso", content = @Content),
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou campos obrigatórios vazios", content = @Content),
    @ApiResponse(responseCode = "409", description = "endereco já cadastrado no sistema", content = @Content)
})
    public ResponseEntity<EnderecoDTOResponse> inserir(@RequestBody @Valid EnderecoDTORequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.inserir(request));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um endereco", description = "Atualiza os dados de um endereco existente")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "endereco atualizado com sucesso", content = @Content),
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou campos obrigatórios vazios", content = @Content),
    @ApiResponse(responseCode = "404", description = "endereco não encontrado com o ID informado", content = @Content)
})
    public ResponseEntity<EnderecoDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid EnderecoDTORequest request) {
        return ResponseEntity.ok(enderecoService.atualizar(id, request));
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um endereco", description = "Remove um endereco pelo ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "endereco removido com sucesso", content = @Content),
    @ApiResponse(responseCode = "404", description = "endereco não encontrado com o ID informado", content = @Content)
})
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();}
}
