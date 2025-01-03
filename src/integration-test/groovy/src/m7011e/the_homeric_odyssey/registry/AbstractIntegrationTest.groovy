package src.m7011e.the_homeric_odyssey.registry

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = [TestContainersConfiguration]
)
@Testcontainers
abstract class AbstractIntegrationSpec extends Specification {

    @Autowired
    PostgreSQLContainer postgreSQLContainer

    @Autowired
    GenericContainer redisContainer

    @Autowired
    GenericContainer keycloakContainer

    @Autowired
    WebTestClient webTestClient
}

// Example usage
class ExampleControllerSpec extends AbstractIntegrationSpec {
