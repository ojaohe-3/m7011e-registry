package m7011e.the_homeric_odyssey.registry.configs;

import m7011e.the_homeric_odyssey.registry.models.commands.UserCommand;
import m7011e.the_homeric_odyssey.registry.models.domain.User;
import m7011e.the_homeric_odyssey.registry.orm.UserDb;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfigurations {

    public void configureModelMapper(ModelMapper modelMapper) {

        modelMapper.createTypeMap(User.class, UserDb.class);
        modelMapper.createTypeMap(UserDb.class, User.class);
        modelMapper.createTypeMap(User.class, UserCommand.class);
        modelMapper.createTypeMap(UserCommand.class, UserCommand.class);

    }

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration();
        configureModelMapper(modelMapper);
        return modelMapper;
    }
}
