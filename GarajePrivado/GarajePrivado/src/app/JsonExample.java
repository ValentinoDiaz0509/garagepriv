package app;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.ClienteDTO;
import config.JacksonConfig;

/**
 * Small utility that serializes and deserializes a {@link ClienteDTO} instance
 * to verify that field names are handled in snake_case.
 */
public class JsonExample {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = JacksonConfig.createObjectMapper();
        ClienteDTO dto = new ClienteDTO("Juan Perez", "123456789");
        String json = mapper.writeValueAsString(dto);
        System.out.println("JSON generado: " + json);
        ClienteDTO result = mapper.readValue(json, ClienteDTO.class);
        System.out.println("Objeto deserializado: " + result);
    }
}
