package caioifto.trabalhoapirest.repositories;

import caioifto.trabalhoapirest.models.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, UUID> {
    List<PessoaFisica> findByAtivoTrue();

    List<PessoaFisica> findByAtivoTrueAndInstrumentoPrincipalEqualsIgnoreCase(String instrumentoPrincipal);
}
