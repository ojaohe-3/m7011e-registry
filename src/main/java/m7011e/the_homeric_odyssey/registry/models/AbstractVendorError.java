package m7011e.the_homeric_odyssey.registry.models;

import lombok.Getter;
import m7011e.the_homeric_odyssey.registry.models.domain.ErrorMessage;

@Getter
public abstract class AbstractVendorError extends RuntimeException {
    protected ErrorMessage errorMessage;

    public AbstractVendorError(String message) {
        super(message);
    }
}
