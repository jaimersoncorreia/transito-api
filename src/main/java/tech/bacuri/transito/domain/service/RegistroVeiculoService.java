package tech.bacuri.transito.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.bacuri.transito.domain.exception.EntidadeNaoEncontradaException;
import tech.bacuri.transito.domain.exception.NegocioException;
import tech.bacuri.transito.domain.model.StatusVeiculo;
import tech.bacuri.transito.domain.model.Veiculo;
import tech.bacuri.transito.domain.repository.VeiculoRepository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistroVeiculoService {
    private final VeiculoRepository veiculoRepository;
    private final RegistroProprietarioService registroProprietarioService;

    @Transactional
    public Veiculo cadastrar(Veiculo veiculo) {
        if (veiculo.getId() != null)
            throw new NegocioException("O veículo a ser cadastrado não deve possuir um ID");

        if (placaEmUso(veiculo))
            throw new NegocioException("Já existe um veículo cadastrado com esta placa");

        veiculo.setProprietario(registroProprietarioService.obter(veiculo.getProprietario().getId()));
        veiculo.setStatus(StatusVeiculo.REGULAR);
        veiculo.setDataCadastro(OffsetDateTime.now());

        return veiculoRepository.save(veiculo);
    }

    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> obter(Long id) {
        return veiculoRepository.findById(id);
    }


    public Veiculo buscar(Long veiculoId) {
        return this.obter(veiculoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Veículo não encontrado!"));
    }

    private boolean placaEmUso(Veiculo veiculo) {
        return veiculoRepository
                .findByPlaca(veiculo.getPlaca())
                .filter(veiculo2 -> !veiculo2.equals(veiculo))
                .isPresent();
    }
}
