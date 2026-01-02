package caioifto.trabalhoapirest.mappers;

import caioifto.trabalhoapirest.dtos.request.PessoaFisicaPostDTO;
import caioifto.trabalhoapirest.dtos.request.PessoaFisicaPutDTO;
import caioifto.trabalhoapirest.dtos.response.PessoaFisicaResponseDTO;
import caioifto.trabalhoapirest.models.PessoaFisica;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ContratoMapper.class})
public interface PessoaFisicaMapper {
    // REQUEST:
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "bandas", ignore = true)
    PessoaFisica toEntity(PessoaFisicaPostDTO body);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "cpf", ignore = true)
    @Mapping(target = "bandas", ignore = true)
    void updatePessoaFisica(PessoaFisicaPutDTO body, @MappingTarget PessoaFisica musico);

    // RESPONSE:
    PessoaFisicaResponseDTO toDTO(PessoaFisica musico);

    List<PessoaFisicaResponseDTO> toDTOList(List<PessoaFisica> musicos);
}
