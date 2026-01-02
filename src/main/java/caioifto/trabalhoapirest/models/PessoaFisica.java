package caioifto.trabalhoapirest.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@PrimaryKeyJoinColumn
@SQLDelete(sql = "UPDATE pessoa SET ativo = false WHERE id = ?")
public class PessoaFisica extends Pessoa {

    @CPF(message = "Fortmato do CPF inválido.")
    @NotBlank(message = "O CPF é obrigatório.")
    private String cpf;

    @OneToMany(mappedBy = "musico", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @SQLRestriction("ativo <> false")
    private List<Contrato> bandas;

    @NotBlank(message = "O instrumento principal é obrigatório.")
    private String instrumentoPrincipal;
}
