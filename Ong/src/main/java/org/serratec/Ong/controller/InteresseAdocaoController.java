package org.serratec.Ong.controller;


import java.util.List;


import org.serratec.Ong.dto.InteresseAdocaoDTORequest;
import org.serratec.Ong.dto.InteresseAdocaoDTOResponse;
import org.serratec.Ong.service.InteresseAdocaoService;
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
@RequestMapping("/interesses")
public class InteresseAdocaoController {
    @Autowired
    private InteresseAdocaoService interesseAdocaoService;

    @GetMapping
    @Operation(summary = "Lista todos os interesses", description = "Retorna uma lista com todos os interesses cadastrados")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Interesses encontrados"),
    })
    public ResponseEntity<List<InteresseAdocaoDTOResponse>> listar() {
        return ResponseEntity.ok(interesseAdocaoService.listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca interesse por ID", description = "Retorna os detalhes de um interesse pelo ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Interesse encontrado", content = @Content),
    @ApiResponse(responseCode = "404", description = "Interesse não encontrado com o ID informado", content = @Content)
    })
    public ResponseEntity<InteresseAdocaoDTOResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(interesseAdocaoService.buscarPorId(id));
    }
    
    @PostMapping
    @Operation(summary = "Cadastra um interesse", description = "Cria um novo interesse no sistema")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "201", description = "Interesse cadastrado com sucesso", content = @Content),
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou campos obrigatórios vazios", content = @Content),
    @ApiResponse(responseCode = "409", description = "Interesse já cadastrado no sistema", content = @Content)
})
    public ResponseEntity<InteresseAdocaoDTOResponse> inserir(@RequestBody @Valid InteresseAdocaoDTORequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(interesseAdocaoService.inserir(request));
    }
    
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um Interesse", description = "Atualiza os dados de um Interesse existente")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Interesse atualizado com sucesso", content = @Content),
    @ApiResponse(responseCode = "400", description = "Dados inválidos ou campos obrigatórios vazios", content = @Content),
    @ApiResponse(responseCode = "404", description = "Interesse não encontrado com o ID informado", content = @Content)
})
    public ResponseEntity<InteresseAdocaoDTOResponse> atualizar(@PathVariable Long id, @RequestBody @Valid InteresseAdocaoDTORequest request) {
        return ResponseEntity.ok(interesseAdocaoService.atualizar(id, request));
    }
    
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um interesse", description = "Remove um interesse pelo ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "204", description = "Interesse removido com sucesso", content = @Content),
    @ApiResponse(responseCode = "404", description = "Interesse não encontrado com o ID informado", content = @Content)
})
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        interesseAdocaoService.deletar(id);
        return ResponseEntity.noContent().build();}
}
