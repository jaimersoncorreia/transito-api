package tech.bacuri.transito.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.bacuri.transito.domain.exception.NegocioException;
import tech.bacuri.transito.domain.model.Veiculo;
import tech.bacuri.transito.domain.service.RegistroVeiculoService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<Map<String, String>> capturar(NegocioException e) {
        Map<String, String> body = new HashMap<>();
        body.put("message", e.getMessage());
        return ResponseEntity.badRequest().body(body);
    }
}
