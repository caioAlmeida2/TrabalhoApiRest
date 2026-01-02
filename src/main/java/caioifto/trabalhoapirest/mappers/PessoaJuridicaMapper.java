package caioifto.trabalhoapirest.mappers;

import caioifto.trabalhoapirest.dtos.request.PessoaJuridicaPostDTO;
import caioifto.trabalhoapirest.dtos.request.PessoaJuridicaPutDTO;
import caioifto.trabalhoapirest.dtos.response.PessoaJuridicaResponseDTO;
import caioifto.trabalhoapirest.models.PessoaJuridica;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ContratoMapper.class})
public interface PessoaJuridicaMapper {
    //REQUEST:
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "musicos", ignore = true)
    PessoaJuridica toEntity(PessoaJuridicaPostDTO body);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "cnpj", ignore = true)
    @Mapping(target = "musicos", ignore = true)
    void updatePessoaJuridica(PessoaJuridicaPutDTO body, @MappingTarget PessoaJuridica banda);

    // RESPONSE:
    PessoaJuridicaResponseDTO toDTO(PessoaJuridica banda);

    List<PessoaJuridicaResponseDTO> toDTOList(List<PessoaJuridica> bandas);
}
