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
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@PrimaryKeyJoinColumn
@SQLDelete(sql = "UPDATE pessoa SET ativo = false WHERE id = ?")
public class PessoaJuridica extends Pessoa {

    @CNPJ(message = "Fortmato do CNPJ inválido.")
    @NotBlank(message = "O CNPJ é obrigatório.")
    private String cnpj;

    @NotBlank(message = "O gênero musical é obrigatório.")
    private String generoMusical;

    @OneToMany(mappedBy = "banda", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @SQLRestriction("ativo <> false")
    private List<Contrato> musicos;

}
