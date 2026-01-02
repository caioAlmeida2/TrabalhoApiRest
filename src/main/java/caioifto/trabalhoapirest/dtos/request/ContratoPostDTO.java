package caioifto.trabalhoapirest.dtos.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ContratoPostDTO(
        @NotNull(message = "Informe a banda.") UUID idBanda,
        @NotNull(message = "Informe o músico.") UUID idMusico,
        @NotNull(message = "Informe o valor do contrato.") Double valorContrato) {
}
