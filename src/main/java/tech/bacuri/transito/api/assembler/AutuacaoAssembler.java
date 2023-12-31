package tech.bacuri.transito.api.assembler;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import tech.bacuri.transito.api.dto.AutuacaoDto;
import tech.bacuri.transito.api.dto.input.AutuacaoInput;
import tech.bacuri.transito.domain.model.Autuacao;

import java.util.List;

@AllArgsConstructor
@Component
public class AutuacaoAssembler {
    private final ModelMapper modelMapper;

    public Autuacao toEntity(AutuacaoInput autuacaoInput) {
        return modelMapper.map(autuacaoInput, Autuacao.class);
    }

    public AutuacaoDto toDto(Autuacao autuacao) {
        return modelMapper.map(autuacao, AutuacaoDto.class);
    }

    public List<AutuacaoDto> toListDto(List<Autuacao> autuacoes) {
        return autuacoes.stream().map(this::toDto).toList();
    }
}
