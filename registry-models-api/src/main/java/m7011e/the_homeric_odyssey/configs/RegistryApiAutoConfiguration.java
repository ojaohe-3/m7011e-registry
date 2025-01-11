package m7011e.the_homeric_odyssey.configs;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages= "m7011e.the_homeric_odyssey.api")
@EnableFeignClients(basePackages= "m7011e.the_homeric_odyssey.api")
public class RegistryApiAutoConfiguration {
}
