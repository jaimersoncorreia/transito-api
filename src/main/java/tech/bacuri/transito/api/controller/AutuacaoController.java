package tech.bacuri.transito.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.bacuri.transito.api.assembler.AutuacaoAssembler;
import tech.bacuri.transito.api.dto.AutuacaoDto;
import tech.bacuri.transito.api.dto.input.AutuacaoInput;
import tech.bacuri.transito.domain.model.Autuacao;
import tech.bacuri.transito.domain.service.RegistroAutuacaoService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {
    private final RegistroAutuacaoService registroAutuacaoService;
    private final AutuacaoAssembler autuacaoAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoDto registrar(@PathVariable Long veiculoId, @Valid @RequestBody AutuacaoInput autuacaoInput) {
        Autuacao registrar = registroAutuacaoService.registrar(veiculoId, autuacaoAssembler.toEntity(autuacaoInput));
        return autuacaoAssembler.toDto(registrar);
    }

    @GetMapping
    public ResponseEntity<List<AutuacaoDto>> listar(@PathVariable Long veiculoId) {
        List<Autuacao> autuacoes = registroAutuacaoService.listar(veiculoId);
        return ResponseEntity.ok(autuacaoAssembler.toListDto(autuacoes));
    }
}
