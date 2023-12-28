package tech.bacuri.transito.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "proprietario")
public class Proprietario {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "proprietario", sequenceName = "sq_proprietario", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proprietario")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "fone")
    private String telefone;
}
