package be.vans.lemaggistral.models.exceptions;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class HttpExceptionDTO {
    private int status;
    private String message;

    private Map<String, String> errors;
}

