package caioifto.trabalhoapirest.dtos.response;

import java.util.List;
import java.util.UUID;

public record PessoaJuridicaResponseDTO(
        UUID id,
        String nome,
        String cnpj,
        String telefone,
        String email,
        String generoMusical,
        List<ContratoResponseDTO> musicos) {
}
