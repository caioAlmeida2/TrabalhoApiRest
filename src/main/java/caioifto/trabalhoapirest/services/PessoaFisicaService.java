package caioifto.trabalhoapirest.services;

import caioifto.trabalhoapirest.dtos.request.PessoaFisicaPostDTO;
import caioifto.trabalhoapirest.dtos.request.PessoaFisicaPutDTO;
import caioifto.trabalhoapirest.dtos.response.PessoaFisicaResponseDTO;
import caioifto.trabalhoapirest.mappers.PessoaFisicaMapper;
import caioifto.trabalhoapirest.models.PessoaFisica;
import caioifto.trabalhoapirest.repositories.PessoaFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PessoaFisicaService {
    @Autowired
    private PessoaFisicaMapper mapper;
    @Autowired
    private PessoaFisicaRepository repository;

    public List<PessoaFisicaResponseDTO> listAllMusicos() {
        return mapper.toDTOList(repository.findByAtivoTrue());
    }

    public List<PessoaFisicaResponseDTO> listByInstrumento(String instrumento) {
        instrumento = instrumento.strip();
        return mapper.toDTOList(repository.findByAtivoTrueAndInstrumentoPrincipalEqualsIgnoreCase(instrumento));
    }

    public PessoaFisicaResponseDTO createMusico(PessoaFisicaPostDTO body) {
        var pessoaFisica = mapper.toEntity(body);
        pessoaFisica.setAtivo(true);

        return mapper.toDTO(repository.save(pessoaFisica));
    }

    public PessoaFisicaResponseDTO updateMusico(UUID id, PessoaFisicaPutDTO body) {
        var pessoaFisica = this.getPessoaFisica(id);
        mapper.updatePessoaFisica(body, pessoaFisica);

        return mapper.toDTO(repository.save(pessoaFisica));
    }

    public PessoaFisicaResponseDTO deleteMusico(UUID id) {
        var pessoaFisica = this.getPessoaFisica(id);
        repository.delete(pessoaFisica);

        return mapper.toDTO(pessoaFisica);
    }

    private PessoaFisica getPessoaFisica(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Músico não encontrado."));
    }
}
