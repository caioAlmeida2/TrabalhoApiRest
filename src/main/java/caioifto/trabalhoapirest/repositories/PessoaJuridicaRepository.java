package caioifto.trabalhoapirest.repositories;

import caioifto.trabalhoapirest.models.PessoaJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, UUID> {
    List<PessoaJuridica> findByAtivoTrue();

    List<PessoaJuridica> findByAtivoTrueAndGeneroMusicalEqualsIgnoreCase(String generoMusical);
}
