package tech.bacuri.transito.api.dto;

import lombok.*;
import tech.bacuri.transito.domain.model.StatusVeiculo;
import tech.bacuri.transito.domain.model.Veiculo;

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

    private String proprietario;

    private String marca;

    private String modelo;

    private String numeroPlaca;

    private StatusVeiculo status;

    private OffsetDateTime dataCadastro;

    private OffsetDateTime dataApreensao;

    public static VeiculoDto from(Veiculo veiculo) {
        return VeiculoDto
                .builder()
                .id(veiculo.getId())
                .proprietario(veiculo.getProprietario().getNome())
                .marca(veiculo.getMarca())
                .modelo(veiculo.getModelo())
                .numeroPlaca(veiculo.getPlaca())
                .status(veiculo.getStatus())
                .dataCadastro(veiculo.getDataCadastro())
                .dataApreensao(veiculo.getDataApreensao())
                .build();
    }
}
