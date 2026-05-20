package org.serratec.Ong.controller;

import java.util.List;

import org.serratec.Ong.dto.AnimalDTORequest;
import org.serratec.Ong.dto.AnimalDTOResponse;
import org.serratec.Ong.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    @Operation(summary = "Lista todos os animais", description = "Retorna uma lista com todos os animais cadastrados")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Animais encontrados"),
    })
    public ResponseEntity<List<AnimalDTOResponse>> listar() {
        return ResponseEntity.ok(animalService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca animal por ID", description = "Retorna os detalhes de um animal pelo ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Animal encontrado", content = @Content),
    @ApiResponse(responseCode = "404", description = "Animal não encontrado com o ID informado", content = @Content),
    @ApiResponse(responseCode = "409", description = "Recurso já cadastrado no sistema", content = @Content)
    })
    public ResponseEntity<AnimalDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.buscarPorId(id));
    }
    
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Animal cadastrado com sucesso", content = @Content),
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou campos obrigatórios vazios", content = @Content),
    @ApiResponse(responseCode = "409", description = "Animal já cadastrado no sistema", content = @Content)
})
    @PostMapping
    @Operation(summary = "Cadastra um animal", description = "Cria um novo animal no sistema")
    public ResponseEntity<AnimalDTOResponse> inserir(@RequestBody @Valid AnimalDTORequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.inserir(request));
    }
    
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Animal atualizado com sucesso", content = @Content),
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou campos obrigatórios vazios", content = @Content),
    @ApiResponse(responseCode = "404", description = "Animal não encontrado com o ID informado", content = @Content)
})
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um animal", description = "Atualiza os dados de um animal existente")
    public ResponseEntity<AnimalDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AnimalDTORequest request) {
        return ResponseEntity.ok(animalService.atualizar(id, request));
    }
    
    @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Animal removido com sucesso", content = @Content),
    @ApiResponse(responseCode = "404", description = "Animal não encontrado com o ID informado", content = @Content)
})
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um animal", description = "Remove um animal pelo ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        animalService.deletar(id);
        return ResponseEntity.noContent().build();}
    }
