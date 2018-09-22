package io.hawt.springboot2;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import io.hawt.system.ConfigManager;

/**
 * Auto configuration for hawtio on Spring Boot.
 */
@Configuration
@ConditionalOnWebApplication
@PropertySource("classpath:/io/hawt/springboot2/application.properties")
@EnableConfigurationProperties
public class HawtioAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnEnabledEndpoint
    public HawtioEndpoint hawtioEndpoint() {
        return new HawtioEndpoint();
    }

    @Bean
    public ConfigManager hawtioConfigManager(
            final HawtioProperties hawtioProperties) {
        return new ConfigManager(hawtioProperties.get()::get);
    }

    @Bean
    public HawtioProperties hawtioProperties() {
        return new HawtioProperties(hawtioConfigurationProperties().getHawtio());
    }

    @Bean
    @ConfigurationProperties
    protected HawtioConfigurationProperties hawtioConfigurationProperties() {
        return new HawtioConfigurationProperties();
    }

    @Bean
    public ManagementContextResolver managementContextResolver(ApplicationContext applicationContext) {
        return new ManagementContextResolver(applicationContext);
    }

    
    protected static class HawtioConfigurationProperties {

        private final Map<String, String> hawtio = new HashMap<>();

        public Map<String, String> getHawtio() {
            return hawtio;
        }
    }
}
