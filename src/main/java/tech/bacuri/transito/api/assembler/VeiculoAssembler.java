package tech.bacuri.transito.api.assembler;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import tech.bacuri.transito.api.dto.VeiculoDto;
import tech.bacuri.transito.api.dto.input.VeiculoInput;
import tech.bacuri.transito.domain.model.Veiculo;

import java.util.List;

@AllArgsConstructor
@Component
public class VeiculoAssembler {
    private final ModelMapper modelMapper;

    public Veiculo toEntity(VeiculoInput veiculoInput) {
        return modelMapper.map(veiculoInput, Veiculo.class);
    }

    public VeiculoDto toDto(Veiculo veiculo) {
        return modelMapper.map(veiculo, VeiculoDto.class);
    }

    public List<VeiculoDto> toListDto(List<Veiculo> veiculos) {
        return veiculos
                .stream()
                .map(this::toDto)
                .toList();
    }
}
