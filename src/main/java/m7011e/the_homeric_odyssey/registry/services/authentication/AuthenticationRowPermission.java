package m7011e.the_homeric_odyssey.registry.services.authentication;

public interface AuthenticationRowPermission<T> {

    boolean hasReadPermission(T resource);

    boolean hasWritePermission(T resource);
}
