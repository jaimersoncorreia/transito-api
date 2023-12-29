package tech.bacuri.transito.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.bacuri.transito.domain.model.Veiculo;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Optional<Veiculo> findByPlaca(String placa);
}
