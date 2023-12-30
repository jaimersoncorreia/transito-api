package tech.bacuri.transito.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.bacuri.transito.domain.exception.NegocioException;
import tech.bacuri.transito.domain.model.Proprietario;
import tech.bacuri.transito.domain.repository.ProprietarioRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RegistroProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    public List<Proprietario> listarTodos() {
        return proprietarioRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<Proprietario> buscar(Long id) {
        return proprietarioRepository.findById(id);
    }

    public Proprietario obter(Long id) {
        return proprietarioRepository
                .findById(id)
                .orElseThrow(() -> new NegocioException("Proprietário não encontrado!"));
    }

    public boolean existsById(Long id) {
        return proprietarioRepository.existsById(id);
    }

    @Transactional
    public Proprietario salvar(Proprietario proprietario) {
        boolean emailEmUso = this.emailEmUso(proprietario);

        if (emailEmUso)
            throw new NegocioException("Já existe um proprietário cadastrado com esse e-mail");

        return proprietarioRepository.save(proprietario);
    }

    private boolean emailEmUso(Proprietario proprietario) {
        return proprietarioRepository
                .findByEmail(proprietario.getEmail())
                .filter(p -> !p.equals(proprietario))
                .isPresent();
    }

    @Transactional
    public Proprietario atualizar(Proprietario proprietario) {
        if (!existsById(proprietario.getId()))
            throw new RuntimeException("Proprietário não encontrado!");

        return salvar(proprietario);
    }

    @Transactional
    public void deletar(Long id) {
        if (!existsById(id))
            throw new RuntimeException("Proprietário não encontrado!");

        proprietarioRepository.deleteById(id);
    }

}
