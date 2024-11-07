package m7011e.the_homeric_odyssey.registry.modelmapper

import m7011e.the_homeric_odyssey.registry.configs.ModelMapperConfigurations
import org.modelmapper.ModelMapper
import spock.lang.Specification

class ModelMapperSpec extends Specification{
    private final ModelMapper modelMapper = new ModelMapper()

    private final ModelMapperConfigurations configurations = new ModelMapperConfigurations();

    def setup() {
        configurations.configureModelMapper(modelMapper)
    }

    def "Modelmapper is configured in a valid way"() {
        when:
        modelMapper.validate()

        then:
        noExceptionThrown()
    }
}
