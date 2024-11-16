package m7011e.the_homeric_odyssey.registry.api;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "registry",
        url = "${registry.api.url}",
        path = "users",
        primary = false
)
public interface UserApiClient extends UserApi {
 String FQN = "m7011e.the_homeric_odyssey.registry.api.UserApiClient";
}
