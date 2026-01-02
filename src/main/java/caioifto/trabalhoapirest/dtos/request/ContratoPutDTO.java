package caioifto.trabalhoapirest.dtos.request;

import jakarta.validation.constraints.NotNull;

public record ContratoPutDTO(
        @NotNull(message = "Informe o valor do contrato.") Double valorContrato) {
}
