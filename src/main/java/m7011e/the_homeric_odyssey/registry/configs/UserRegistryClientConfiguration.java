package m7011e.the_homeric_odyssey.registry.configs;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableFeignClients
public class UserRegistryClientConfiguration {
}
