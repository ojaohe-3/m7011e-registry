package m7011e.the_homeric_odyssey.registry.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@Configuration
@PropertySource("classpath:application.yaml")
public class RegistryConfigurations {

    @Bean
    public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {
        return new ShallowEtagHeaderFilter();
    }
}
