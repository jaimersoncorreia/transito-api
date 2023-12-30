package tech.bacuri.transito.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.bacuri.transito.api.dto.VeiculoDto;
import tech.bacuri.transito.domain.model.Veiculo;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.createTypeMap(Veiculo.class, VeiculoDto.class)
                .addMappings(mapper -> mapper.map(Veiculo::getPlaca, VeiculoDto::setNumeroPlaca))
                .addMappings(mapper -> mapper.map(veiculo -> veiculo.getProprietario().getNome(), VeiculoDto::setProprietario));

        return modelMapper;
    }
}
