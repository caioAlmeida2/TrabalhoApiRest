package caioifto.trabalhoapirest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@SQLDelete(sql = "UPDATE pessoa SET ativo = false WHERE id = ?")
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome é obrigatório.")
    @Size(max = 150, message = "Nome não pode exceder 150 caracteres.")
    private String nome;

    @NotBlank(message = "O telefone é obrigatório.")
    @Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$", message = "Telefone deve estar no formato: (XX) XXXX-XXXX ou (XX) XXXXX-XXXX.")
    private String telefone;

    @Email(message = "Formato de E-mail inválido.")
    @NotBlank(message = "O email é obrigatório.")
    private String email;

    @NotNull
    private Boolean ativo;

}
