package tech.bacuri.transito.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.bacuri.transito.domain.model.Autuacao;

import java.util.List;

@AllArgsConstructor
@Service
public class RegistroAutuacaoService {

    private final RegistroVeiculoService registroVeiculoService;

    @Transactional
    public Autuacao registrar(Long veiculoId, Autuacao novaAutuacao) {
        return registroVeiculoService
                .buscar(veiculoId)
                .adicionarAutuacao(novaAutuacao);
    }

    public List<Autuacao> listar(Long veiculoId) {
        return registroVeiculoService.buscar(veiculoId).getAutuacoes();
    }
}
