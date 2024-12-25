package m7011e.the_homeric_odyssey.registry_orm.configs;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackages= "m7011e.the_homeric_odyssey.api")
@AutoConfiguration
@EnableFeignClients(basePackages= "m7011e.the_homeric_odyssey.api")
public class RegistryApiAutoConfiguration {
}
