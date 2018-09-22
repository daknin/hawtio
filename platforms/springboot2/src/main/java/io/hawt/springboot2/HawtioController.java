package io.hawt.springboot2;

import static io.hawt.springboot2.HawtioProperties.HAWTIO_REQUEST_MAPPING;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;

@RequestMapping(value = HAWTIO_REQUEST_MAPPING)
public class HawtioController {

    @RequestMapping(value = {"", "/"}, produces = MediaType.TEXT_HTML_VALUE)
    public String redirectRootToIndexPage(final HttpServletRequest request) {
        return getIndexHtmlRedirect(request);
    }

    protected String getIndexHtmlRedirect(final HttpServletRequest request) {
        UriComponentsBuilder builder = ServletUriComponentsBuilder.fromRequest(request);
        // append "/index.html" to the current path
        builder.path("/index.html");
        UriComponents uriComponents = builder.build();
        String path = uriComponents.getPath();
        return "forward:" + path;
    }
}
