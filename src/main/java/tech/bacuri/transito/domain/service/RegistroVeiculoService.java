package tech.bacuri.transito.domain.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tech.bacuri.transito.domain.model.Veiculo;
import tech.bacuri.transito.domain.repository.VeiculoRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistroVeiculoService {
    private final VeiculoRepository veiculoRepository;

    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> obter(Long id) {
        return veiculoRepository.findById(id);
    }
}
