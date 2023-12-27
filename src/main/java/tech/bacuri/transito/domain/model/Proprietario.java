package tech.bacuri.transito.domain.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Proprietario {
    private Long id;
    private String nome;
    private String email;
    private String telefone;
}
