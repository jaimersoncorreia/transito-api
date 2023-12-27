package tech.bacuri.transito.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.bacuri.transito.domain.model.Proprietario;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProprietarioController {

    @GetMapping("/proprietarios")
    public List<Proprietario> listar() {

        Proprietario proprietario1 = Proprietario
                .builder()
                .id(1L)
                .nome("João")
                .telefone("92 99595 4566")
                .email("joao@bacuri.tech")
                .build();

        Proprietario proprietario2 = Proprietario
                .builder()
                .id(2L)
                .nome("Maria")
                .telefone("92 99595 4577")
                .email("maria@bacuri.tech")
                .build();
        return Arrays.asList(proprietario1, proprietario2);
    }
}
