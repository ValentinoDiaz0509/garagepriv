package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple data transfer object representing a client. The record components are
 * annotated with {@link JsonProperty} using snake_case names to demonstrate the
 * naming strategy.
 */
public record ClienteDTO(
        @JsonProperty("nombre_completo") String nombreCompleto,
        @JsonProperty("telefono_movil") String telefonoMovil) {
}
