package io.hawt.springboot2;

import org.springframework.context.ApplicationContext;

/*
 * Replacement for deleted org.springframework.boot.actuate.autoconfigure.endpoint.ManagementContextResolver
 */
public class ManagementContextResolver {
    private ApplicationContext applicationContext;

    ManagementContextResolver(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
