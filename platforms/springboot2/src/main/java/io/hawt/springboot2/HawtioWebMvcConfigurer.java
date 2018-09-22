package io.hawt.springboot2;

import static io.hawt.springboot2.HawtioProperties.HAWTIO_REQUEST_MAPPING;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class HawtioWebMvcConfigurer implements WebMvcConfigurer {
    private String managementContextPrefix = ""; // TODO

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry // @formatter:off
            .addResourceHandler(managementContextPrefix + getPath() + "/plugins/**")
            .addResourceLocations(
                "/app/",
                "classpath:/hawtio-static/app/");
        registry
            .addResourceHandler(managementContextPrefix + getPath() + "/**")
            .addResourceLocations(
                "/",
                "/app/",
                "classpath:/hawtio-static/",
                "classpath:/hawtio-static/app/");
        registry
            .addResourceHandler("/img/**")
            .addResourceLocations("classpath:/hawtio-static/img/"); // @formatter:on
    }

    private String getPath() {
        return HAWTIO_REQUEST_MAPPING;
    }
}
