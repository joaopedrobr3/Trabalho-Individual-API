package org.serratec.Ong.controller;

import java.util.List;

import org.serratec.Ong.dto.CaracteristicaDTORequest;
import org.serratec.Ong.dto.CaracteristicaDTOResponse;
import org.serratec.Ong.service.CaracteristicaService;
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
@RequestMapping("/caracteristicas")
public class CaracteristicaController {

    @Autowired
    private CaracteristicaService caracteristicaService;

    @GetMapping
    @Operation(summary = "Lista todas as caracteristicas", description = "Retorna uma lista com todas as caracteristicas cadastradas")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Caracteristicas encontradas"),
    })
    public ResponseEntity<List<CaracteristicaDTOResponse>> listar() {
        return ResponseEntity.ok(caracteristicaService.listar());
    }

    @GetMapping("/{id}")
   @Operation(summary = "Busca caracteristica por ID", description = "Retorna os detalhes de uma caracteristica pelo ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Caracteristica encontrada", content = @Content),
    @ApiResponse(responseCode = "404", description = "Caracteristica não encontrada com o ID informado", content = @Content)
    })
    
    public ResponseEntity<CaracteristicaDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(caracteristicaService.buscarPorId(id));
    }

    @PostMapping
    @Operation(summary = "Cadastra um caracteristica", description = "Cria um novo caracteristica no sistema")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Caracteristica cadastrada com sucesso", content = @Content),
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou campos obrigatórios vazios", content = @Content),
    @ApiResponse(responseCode = "409", description = "Caracteristica já cadastrada no sistema", content = @Content)
   })
    public ResponseEntity<CaracteristicaDTOResponse> inserir(@RequestBody @Valid CaracteristicaDTORequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(caracteristicaService.inserir(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um caracteristica", description = "Atualiza os dados de um caracteristica existente")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Caracteristica atualizada com sucesso", content = @Content),
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou campos obrigatórios vazios", content = @Content),
    @ApiResponse(responseCode = "404", description = "Caracteristica não encontrada com o ID informado", content = @Content)
})
    public ResponseEntity<CaracteristicaDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid CaracteristicaDTORequest request) {
        return ResponseEntity.ok(caracteristicaService.atualizar(id, request));
    }
  
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um caracteristica", description = "Remove um caracteristica pelo ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Caracteristica removida com sucesso", content = @Content),
    @ApiResponse(responseCode = "404", description = "Caracteristica não encontrada com o ID informado", content = @Content)
})
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        caracteristicaService.deletar(id);
        return ResponseEntity.noContent().build();}
    }
