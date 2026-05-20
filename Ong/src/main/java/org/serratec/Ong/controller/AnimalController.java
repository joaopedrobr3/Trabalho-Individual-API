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
import jakarta.validation.Valid;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    @Operation(summary = "Lista todos os animais", description = "Retorna uma lista com todos os animais cadastrados")
    public ResponseEntity<List<AnimalDTOResponse>> listar() {
        return ResponseEntity.ok(animalService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca animal por ID", description = "Retorna os detalhes de um animal pelo ID")
    public ResponseEntity<AnimalDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(animalService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Cadastra um animal", description = "Cria um novo animal no sistema")
    public ResponseEntity<AnimalDTOResponse> inserir(@RequestBody @Valid AnimalDTORequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(animalService.inserir(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um animal", description = "Atualiza os dados de um animal existente")
    public ResponseEntity<AnimalDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid AnimalDTORequest request) {
        return ResponseEntity.ok(animalService.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um animal", description = "Remove um animal pelo ID")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        animalService.deletar(id);
        return ResponseEntity.noContent().build();}
    }
