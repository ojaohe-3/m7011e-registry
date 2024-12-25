package m7011e.the_homeric_odyssey.registry_orm;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfiguration
@EntityScan(basePackages = "m7011e.the_homeric_odyssey.registry_orm.orm")
@ComponentScan(basePackages = "m7011e.the_homeric_odyssey.registry_orm")
public class RegistryOrmAutoConfiguration {
}
