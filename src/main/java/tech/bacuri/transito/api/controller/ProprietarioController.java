package tech.bacuri.transito.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.bacuri.transito.domain.model.Proprietario;
import tech.bacuri.transito.domain.repository.ProprietarioRepository;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    private final ProprietarioRepository proprietarioRepository;

    @GetMapping
    public List<Proprietario> listar() {
        return proprietarioRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proprietario> obter(@PathVariable(name = "id") Long id) {
        return proprietarioRepository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Proprietario> salvar(@RequestBody Proprietario proprietario) {
        Proprietario saved = proprietarioRepository.save(proprietario);
        return ResponseEntity
                .created(URI.create("/" + saved.getId()))
                .body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proprietario> atualizar(@PathVariable("id") Long id, @RequestBody Proprietario proprietario) {

        if (!proprietarioRepository.existsById(id))
            return ResponseEntity.notFound().build();

        proprietario.setId(id);

        return ResponseEntity.ok().body(proprietarioRepository.save(proprietario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable(name = "id") Long id) {
        if (!proprietarioRepository.existsById(id))
            return ResponseEntity.notFound().build();

        proprietarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
