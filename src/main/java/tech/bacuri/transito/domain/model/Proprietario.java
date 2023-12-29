package tech.bacuri.transito.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    @Size(max = 255)
    private String nome;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "fone")
    @NotBlank
    @Size(max = 20)
    private String telefone;
}
