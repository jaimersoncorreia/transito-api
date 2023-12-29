package tech.bacuri.transito.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Veiculo {
    @EqualsAndHashCode.Include
    @Id
    @SequenceGenerator(name = "veiculo", sequenceName = "sq_veiculo", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proprietario")
    private long id;

    @ManyToOne
    @JoinColumn(name = "proprietario_id")
    private Proprietario proprietario;

    private String marca;

    private String modelo;

    private String placa;

    @Enumerated(EnumType.STRING)
    private StatusVeiculo status;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataApreensao;
}
