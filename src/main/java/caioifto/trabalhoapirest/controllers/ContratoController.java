package caioifto.trabalhoapirest.controllers;

import caioifto.trabalhoapirest.dtos.request.ContratoPostDTO;
import caioifto.trabalhoapirest.dtos.request.ContratoPutDTO;
import caioifto.trabalhoapirest.dtos.response.ContratoResponseDTO;
import caioifto.trabalhoapirest.services.ContratoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contrato")
public class ContratoController {
    @Autowired
    private ContratoService service;

    @GetMapping("/listar")
    public ResponseEntity<List<ContratoResponseDTO>> listar() {
        return ResponseEntity.ok(service.listAllContratos());
    }

    @Transactional
    @PostMapping("/inserir")
    public ResponseEntity<ContratoResponseDTO> inserir(@Valid @RequestBody ContratoPostDTO body) {
        return ResponseEntity.ok(service.createContrato(body));
    }

    @Transactional
    @PutMapping("/editar/{id}")
    public ResponseEntity<ContratoResponseDTO> editar(@PathVariable UUID id, @Valid @RequestBody ContratoPutDTO body) {
        return ResponseEntity.ok(service.updateContrato(id, body));
    }

    @Transactional
    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<ContratoResponseDTO> deletar(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deleteContrato(id));
    }
}
