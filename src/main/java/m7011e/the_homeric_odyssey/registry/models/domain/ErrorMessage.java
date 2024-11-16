package m7011e.the_homeric_odyssey.registry.models.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    Map<String, String> fieldErrors;
    Map<String, String> errorCodes;
    Map<String, Object> rejectedValues;
}
