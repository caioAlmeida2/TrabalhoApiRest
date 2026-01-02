package caioifto.trabalhoapirest.dtos.response;

import java.util.List;
import java.util.UUID;

public record PessoaFisicaResponseDTO(
        UUID id,
        String nome,
        String cpf,
        String telefone,
        String email,
        String instrumentoPrincipal,
        List<ContratoResponseDTO> bandas) {
}
