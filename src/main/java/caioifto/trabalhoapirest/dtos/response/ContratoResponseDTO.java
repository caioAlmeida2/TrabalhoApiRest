package caioifto.trabalhoapirest.dtos.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record ContratoResponseDTO(
        UUID id,
        String musico,
        String banda,
        LocalDateTime dataContrato,
        Double valorContrato) {

}
