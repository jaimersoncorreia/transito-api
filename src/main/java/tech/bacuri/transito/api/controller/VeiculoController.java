package tech.bacuri.transito.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.bacuri.transito.domain.model.Veiculo;
import tech.bacuri.transito.domain.service.RegistroVeiculoService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final RegistroVeiculoService registroVeiculoService;


    @PostMapping
    public ResponseEntity<Veiculo> cadastrar(@Valid @RequestBody Veiculo veiculo) {
        return new ResponseEntity<>(registroVeiculoService.cadastrar(veiculo), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listar() {
        return ResponseEntity.ok(registroVeiculoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> obter(@PathVariable Long id) {
        return registroVeiculoService.obter(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
