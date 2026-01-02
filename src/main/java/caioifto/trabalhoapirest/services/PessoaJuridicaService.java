package caioifto.trabalhoapirest.services;

import caioifto.trabalhoapirest.dtos.request.PessoaJuridicaPostDTO;
import caioifto.trabalhoapirest.dtos.request.PessoaJuridicaPutDTO;
import caioifto.trabalhoapirest.dtos.response.PessoaJuridicaResponseDTO;
import caioifto.trabalhoapirest.mappers.PessoaJuridicaMapper;
import caioifto.trabalhoapirest.models.PessoaJuridica;
import caioifto.trabalhoapirest.repositories.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PessoaJuridicaService {
    @Autowired
    private PessoaJuridicaRepository repository;
    @Autowired
    private PessoaJuridicaMapper mapper;

    public List<PessoaJuridicaResponseDTO> listAllBandas() {
        return mapper.toDTOList(repository.findByAtivoTrue());
    }

    public List<PessoaJuridicaResponseDTO> listByGenero(String genero) {
        genero = genero.strip();
        return mapper.toDTOList(repository.findByAtivoTrueAndGeneroMusicalEqualsIgnoreCase(genero));
    }

    public PessoaJuridicaResponseDTO createBanda(PessoaJuridicaPostDTO body) {
        var pessoaJuridica = mapper.toEntity(body);
        pessoaJuridica.setAtivo(true);

        return mapper.toDTO(repository.save(pessoaJuridica));
    }

    public PessoaJuridicaResponseDTO updateMusico(UUID id, PessoaJuridicaPutDTO body) {
        var pessoaJuridica = this.getPessoaJuridica(id);
        mapper.updatePessoaJuridica(body, pessoaJuridica);

        return mapper.toDTO(repository.save(pessoaJuridica));
    }

    public PessoaJuridicaResponseDTO deleteMusico(UUID id) {
        var pessoaJuridica = this.getPessoaJuridica(id);
        repository.delete(pessoaJuridica);

        return mapper.toDTO(pessoaJuridica);
    }

    private PessoaJuridica getPessoaJuridica(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Banda não encontrada."));
    }
}

