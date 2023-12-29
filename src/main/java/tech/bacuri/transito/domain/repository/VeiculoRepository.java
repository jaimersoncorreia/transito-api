package tech.bacuri.transito.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.bacuri.transito.domain.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}
