package tech.bacuri.transito.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.bacuri.transito.domain.model.Proprietario;
import tech.bacuri.transito.domain.service.RegistroProprietarioService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/proprietarios")
public class ProprietarioController {

    private final RegistroProprietarioService registroProprietarioService;

    @GetMapping
    public ResponseEntity<List<Proprietario>> listar() {
        return ResponseEntity.ok(registroProprietarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proprietario> obter(@PathVariable(name = "id") Long id) {
        return registroProprietarioService.buscar(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Proprietario> salvar(@Valid @RequestBody Proprietario proprietario) {
        Proprietario saved = registroProprietarioService.salvar(proprietario);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proprietario> atualizar(@PathVariable("id") Long id,
                                                  @Valid @RequestBody Proprietario proprietario) {
        if (!registroProprietarioService.existsById(id))
            return ResponseEntity.notFound().build();

        proprietario.setId(id);

        return ResponseEntity.ok().body(registroProprietarioService.atualizar(proprietario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable(name = "id") Long id) {
        if (!registroProprietarioService.existsById(id))
            return ResponseEntity.notFound().build();

        registroProprietarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
