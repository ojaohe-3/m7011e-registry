package m7011e.the_homeric_odyssey.registry.models;

import java.util.Map;

public record ErrorMessage(Map<String, String> fieldErrors,
                           Map<String, String> errorCodes,
                           Map<String, Object> rejectedValues){}
