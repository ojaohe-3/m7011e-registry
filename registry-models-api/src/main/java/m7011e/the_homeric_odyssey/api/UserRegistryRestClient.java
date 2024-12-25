package m7011e.the_homeric_odyssey.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "registry",
        url = "${registry.api.url}",
        path = "users",
        primary = false
)
public interface UserRegistryRestClient extends UserApi {
    String FQN = "m7011e.the_homeric_odyssey.registry.m7011e.the_homeric_odyssey.api.UserApiClient";
}
