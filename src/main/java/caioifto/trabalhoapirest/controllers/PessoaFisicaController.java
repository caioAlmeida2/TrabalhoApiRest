package caioifto.trabalhoapirest.controllers;

import caioifto.trabalhoapirest.dtos.request.PessoaFisicaPostDTO;
import caioifto.trabalhoapirest.dtos.request.PessoaFisicaPutDTO;
import caioifto.trabalhoapirest.dtos.response.PessoaFisicaResponseDTO;
import caioifto.trabalhoapirest.services.PessoaFisicaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/musicos")
public class PessoaFisicaController {
    @Autowired
    PessoaFisicaService service;

    @GetMapping("/listar")
    public ResponseEntity<List<PessoaFisicaResponseDTO>> listar() {
        return ResponseEntity.ok(service.listAllMusicos());
    }

    @GetMapping("/buscar-instrumento/{instrumento}")
    public ResponseEntity<List<PessoaFisicaResponseDTO>> buscarPorInstrumento(@PathVariable @NotBlank String instrumento) {
        return ResponseEntity.ok(service.listByInstrumento(instrumento));
    }

    @Transactional
    @PostMapping("/inserir")
    public ResponseEntity<PessoaFisicaResponseDTO> inserir(@Valid @RequestBody PessoaFisicaPostDTO body) {
        return ResponseEntity.ok(service.createMusico(body));
    }

    @Transactional
    @PutMapping("/editar/{id}")
    public ResponseEntity<PessoaFisicaResponseDTO> editar(@PathVariable UUID id, @Valid @RequestBody PessoaFisicaPutDTO body) {
        return ResponseEntity.ok(service.updateMusico(id, body));
    }

    @Transactional
    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<PessoaFisicaResponseDTO> deletar(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deleteMusico(id));
    }
}
