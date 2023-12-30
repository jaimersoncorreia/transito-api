package tech.bacuri.transito.api.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProprietarioResumoDto {
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
}
