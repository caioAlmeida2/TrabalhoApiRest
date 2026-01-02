package caioifto.trabalhoapirest.services;

import caioifto.trabalhoapirest.dtos.request.ContratoPostDTO;
import caioifto.trabalhoapirest.dtos.request.ContratoPutDTO;
import caioifto.trabalhoapirest.dtos.response.ContratoResponseDTO;
import caioifto.trabalhoapirest.mappers.ContratoMapper;
import caioifto.trabalhoapirest.models.Contrato;
import caioifto.trabalhoapirest.models.PessoaFisica;
import caioifto.trabalhoapirest.models.PessoaJuridica;
import caioifto.trabalhoapirest.repositories.ContratoRepository;
import caioifto.trabalhoapirest.repositories.PessoaFisicaRepository;
import caioifto.trabalhoapirest.repositories.PessoaJuridicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ContratoService {
    @Autowired
    private ContratoMapper mapper;
    @Autowired
    private ContratoRepository repository;
    @Autowired
    private PessoaJuridicaRepository pjRepository;
    @Autowired
    private PessoaFisicaRepository pfRepository;


    public List<ContratoResponseDTO> listAllContratos() {
        return mapper.toDTOList(repository.findByAtivo(true));
    }

    public ContratoResponseDTO createContrato(ContratoPostDTO body) {
        var pessoaFisica = this.getPessoaFisica(body.idMusico());
        var pessoaJuridica = this.getPessoaJuridica(body.idBanda());

        var contrato = mapper.toEntity(body);
        contrato.setAtivo(true);
        contrato.setBanda(pessoaJuridica);
        contrato.setMusico(pessoaFisica);
        contrato.setDataContrato(LocalDateTime.now());

        return mapper.toDTO(repository.save(contrato));
    }

    public ContratoResponseDTO updateContrato(UUID id, ContratoPutDTO body) {
        var contrato = this.getContrato(id);
        mapper.updateContrato(body, contrato);

        return mapper.toDTO(repository.save(contrato));
    }

    public ContratoResponseDTO deleteContrato(UUID id) {
        var contrato = this.getContrato(id);
        repository.delete(contrato);

        return mapper.toDTO(contrato);
    }

    private Contrato getContrato(UUID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Contrato não encontrado"));
    }

    private PessoaFisica getPessoaFisica(UUID idPessoaFisica) {
        return pfRepository.findById(idPessoaFisica).orElseThrow(() -> new RuntimeException("Músico não encontrado"));
    }

    private PessoaJuridica getPessoaJuridica(UUID idPessoaJuridica) {
        return pjRepository.findById(idPessoaJuridica).orElseThrow(() -> new RuntimeException("Banda não encontrado"));
    }
}
