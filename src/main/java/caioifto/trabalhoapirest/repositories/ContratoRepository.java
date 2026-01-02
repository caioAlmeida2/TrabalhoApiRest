package caioifto.trabalhoapirest.repositories;

import caioifto.trabalhoapirest.models.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ContratoRepository extends JpaRepository<Contrato, UUID> {
    List<Contrato> findByAtivo(Boolean ativo);
}
