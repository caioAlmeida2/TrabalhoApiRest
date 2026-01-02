package caioifto.trabalhoapirest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@SQLDelete(sql = "UPDATE contrato SET ativo = false, data_encerramento = NOW() WHERE id = ?")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private LocalDateTime dataContrato;

    @NotNull(message = "Informe o valor do contrato.")
    private Double valorContrato;

    private LocalDateTime dataEncerramento;

    @NotNull(message = "Informe a banda.")
    @ManyToOne
    private PessoaJuridica banda;

    @NotNull(message = "Informe o músico.")
    @ManyToOne
    private PessoaFisica musico;

    @NotNull
    private Boolean ativo;
}
