package m7011e.the_homeric_odyssey.registry.models;

import lombok.Getter;

@Getter
public abstract class AbstractVendorError extends RuntimeException {
    protected ErrorMessage errorMessage;

    public AbstractVendorError(String message) {
        super(message);
    }
}
