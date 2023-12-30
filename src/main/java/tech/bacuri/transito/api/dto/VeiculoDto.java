package tech.bacuri.transito.api.dto;

import lombok.*;
import tech.bacuri.transito.domain.model.StatusVeiculo;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class VeiculoDto {
    @EqualsAndHashCode.Include
    private Long id;

    private ProprietarioResumoDto proprietario;

    private String marca;

    private String modelo;

    private String numeroPlaca;

    private StatusVeiculo status;

    private OffsetDateTime dataCadastro;

    private OffsetDateTime dataApreensao;
}
