package caioifto.trabalhoapirest.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record PessoaFisicaPostDTO(
        @NotBlank(message = "O nome é obrigatório.") String nome,
        @NotBlank(message = "O nome é obrigatório.") @CPF(message = "Fortmato do CPF inválido.") String cpf,
        @NotBlank(message = "O telefone é obrigatório.") @Pattern(regexp = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$", message = "Telefone deve estar no formato: (XX) XXXX-XXXX ou (XX) XXXXX-XXXX.") String telefone,
        @Email(message = "Formato de E-mail inválido.") @NotBlank(message = "O email é obrigatório.") String email,
        @NotBlank(message = "O instrumento principal é obrigatório.") String instrumentoPrincipal) {

}
