package tech.bacuri.transito.api.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.bacuri.transito.api.assembler.VeiculoAssembler;
import tech.bacuri.transito.api.dto.VeiculoDto;
import tech.bacuri.transito.domain.model.Veiculo;
import tech.bacuri.transito.domain.service.RegistroVeiculoService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final RegistroVeiculoService registroVeiculoService;
    private final VeiculoAssembler veiculoAssembler;


    @PostMapping
    public ResponseEntity<VeiculoDto> cadastrar(@Valid @RequestBody Veiculo veiculo) {
        return new ResponseEntity<>(veiculoAssembler.toModel(registroVeiculoService.cadastrar(veiculo)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDto>> listar() {
        return ResponseEntity.ok(veiculoAssembler.toListDto(registroVeiculoService.listar()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDto> obter(@PathVariable Long id) {
        return registroVeiculoService.obter(id)
                .map(veiculoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
