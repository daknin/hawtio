package io.hawt.springboot2;

import static io.hawt.springboot2.HawtioProperties.HAWTIO_ACTUATOR_ENDPOINT_ID;

import java.util.List;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Spring Boot endpoint to expose hawtio.
 */
@ConfigurationProperties(prefix = "endpoints.hawtio", ignoreUnknownFields = false)
@WebEndpoint(id = HAWTIO_ACTUATOR_ENDPOINT_ID)
public class HawtioEndpoint {

    private List<HawtPlugin> plugins;

    public void setPlugins(final List<HawtPlugin> plugins) {
        this.plugins = plugins;
    }

    @ReadOperation()
    public List<HawtPlugin> getPlugins() {
        return plugins;
    }
}
