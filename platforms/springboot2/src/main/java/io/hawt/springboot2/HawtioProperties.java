package io.hawt.springboot2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Configuration properties for hawtio
 */
public class HawtioProperties {

    public static final String HAWTIO_ACTUATOR_ENDPOINT_ID = "hawtio";

    public static final String JOLOKIA_ACTUATOR_ENDPOINT_ID = "jolokia";

    public static final String HAWTIO_REQUEST_MAPPING = "/hawtio";

    private Map<String, String> properties = new HashMap<>();

    public HawtioProperties(final Map<String, String> properties) {
        this.properties = Objects.requireNonNull(properties);
    }

    public Map<String, String> get() {
        return properties;
    }
}
