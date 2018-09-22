package io.hawt.springboot2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

public class HawtioControllerTest {
    private HawtioController hawtioController;

    @Before
    public void setUp() {
        hawtioController = new HawtioController();
    }

    @Test
    public void testGetIndexHtmlRedirect() {
        runTestGetIndexHtmlRedirect(null, null,
            "forward:/index.html");
        runTestGetIndexHtmlRedirect("", "",
            "forward:/index.html");
        runTestGetIndexHtmlRedirect("/hawtio", null,
            "forward:/hawtio/index.html");
        runTestGetIndexHtmlRedirect("/hawtio/", null,
            "forward:/hawtio/index.html");
    }

    private void runTestGetIndexHtmlRedirect(String requestURI, String queryString, String expectedResult) {
        MockHttpServletRequest request = new MockHttpServletRequest();
        if (requestURI != null) {
            request.setRequestURI(requestURI);
        }
        if (queryString != null) {
            request.setQueryString(queryString);
        }

        String result = hawtioController.getIndexHtmlRedirect(request);

        assertEquals(expectedResult, result);
    }
}
