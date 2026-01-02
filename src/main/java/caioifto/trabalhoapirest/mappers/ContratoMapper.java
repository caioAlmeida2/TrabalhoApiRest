package caioifto.trabalhoapirest.mappers;

import caioifto.trabalhoapirest.dtos.request.ContratoPostDTO;
import caioifto.trabalhoapirest.dtos.request.ContratoPutDTO;
import caioifto.trabalhoapirest.dtos.response.ContratoResponseDTO;
import caioifto.trabalhoapirest.models.Contrato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContratoMapper {
    //REQUEST:
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "banda", ignore = true)
    @Mapping(target = "musico", ignore = true)
    @Mapping(target = "dataContrato", ignore = true)
    Contrato toEntity(ContratoPostDTO body);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "ativo", ignore = true)
    @Mapping(target = "banda", ignore = true)
    @Mapping(target = "musico", ignore = true)
    @Mapping(target = "dataContrato", ignore = true)
    void updateContrato(ContratoPutDTO body, @MappingTarget Contrato contrato);

    // RESPONSE:
    @Mapping(target = "musico", source = "contrato.musico.nome")
    @Mapping(target = "banda", source = "contrato.banda.nome")
    ContratoResponseDTO toDTO(Contrato contrato);

    List<ContratoResponseDTO> toDTOList(List<Contrato> contratos);
}
