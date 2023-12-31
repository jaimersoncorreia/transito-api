package tech.bacuri.transito.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ApreensaoVeiculoService {

    private final RegistroVeiculoService registroVeiculoService;

    public void apreender(Long veiculoId) {
        registroVeiculoService.buscar(veiculoId).apreender();
    }

    public void removerApreensao(Long veiculoId) {
        registroVeiculoService.buscar(veiculoId).removerApreensao();
    }
}
