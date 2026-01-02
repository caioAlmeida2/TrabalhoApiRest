package caioifto.trabalhoapirest.controllers;

import caioifto.trabalhoapirest.dtos.request.PessoaJuridicaPostDTO;
import caioifto.trabalhoapirest.dtos.request.PessoaJuridicaPutDTO;
import caioifto.trabalhoapirest.dtos.response.PessoaJuridicaResponseDTO;
import caioifto.trabalhoapirest.services.PessoaJuridicaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/banda")
public class PessoaJuridicaController {
    @Autowired
    private PessoaJuridicaService service;

    @GetMapping("/listar")
    public ResponseEntity<List<PessoaJuridicaResponseDTO>> listar() {
        return ResponseEntity.ok(service.listAllBandas());
    }

    @GetMapping("/buscar-genero/{genero}")
    public ResponseEntity<List<PessoaJuridicaResponseDTO>> buscarGenero(@PathVariable @NotBlank String genero) {
        return ResponseEntity.ok(service.listByGenero(genero.strip()));
    }

    @Transactional
    @PostMapping("/inserir")
    public ResponseEntity<PessoaJuridicaResponseDTO> inserir(@Valid @RequestBody PessoaJuridicaPostDTO body) {
        return ResponseEntity.ok(service.createBanda(body));
    }

    @Transactional
    @PutMapping("/editar/{id}")
    public ResponseEntity<PessoaJuridicaResponseDTO> editar(@PathVariable UUID id,
                                                            @Valid @RequestBody PessoaJuridicaPutDTO body) {
        return ResponseEntity.ok(service.updateMusico(id, body));
    }

    @Transactional
    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<PessoaJuridicaResponseDTO> deletar(@PathVariable UUID id) {
        return ResponseEntity.ok(service.deleteMusico(id));
    }
}

