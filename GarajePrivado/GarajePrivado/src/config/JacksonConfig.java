package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

/**
 * Provides a preconfigured {@link ObjectMapper} that uses the
 * {@link PropertyNamingStrategies#SNAKE_CASE} strategy so that JSON fields
 * are serialized and deserialized using snake_case.
 */
public class JacksonConfig {
    /**
     * Creates an {@link ObjectMapper} configured to use snake_case for field
     * names.
     *
     * @return configured {@link ObjectMapper}
     */
    public static ObjectMapper createObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        return mapper;
    }
}
