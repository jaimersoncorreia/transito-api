package tech.bacuri.transito.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ApreensaoVeiculoService {

    private final RegistroVeiculoService registroVeiculoService;

    @Transactional
    public void apreender(Long veiculoId) {
        registroVeiculoService.buscar(veiculoId).apreender();
    }

    @Transactional
    public void removerApreensao(Long veiculoId) {
        registroVeiculoService.buscar(veiculoId).removerApreensao();
    }
}
