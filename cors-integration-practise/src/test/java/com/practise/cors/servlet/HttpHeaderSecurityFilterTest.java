package com.practise.cors.servlet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.verify;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import static shiver.me.timbers.data.random.RandomStrings.someString;

/**
 * Created by ashleyj on 16/02/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class HttpHeaderSecurityFilterTest {

    @InjectMocks
    private HttpHeaderSecurityFilter filter;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    private String accessControlAllowMethods = someString();
    private String accessControlAllowHeaders = someString();
    private String accessControlAllowOrigin = someString();
    private String xFrameOptions = someString();
    private String xXssProtection = someString();
    private String xContentTypeOptions = someString();

    @Before
    public void setup() {
        setField(filter, "accessControlAllowMethods", accessControlAllowMethods);
        setField(filter, "accessControlAllowHeaders", accessControlAllowHeaders);
        setField(filter, "accessControlAllowOrigin", accessControlAllowOrigin);
        setField(filter, "xFrameOptions", xFrameOptions);
        setField(filter, "xXssProtection", xXssProtection);
        setField(filter, "xContentTypeOptions", xContentTypeOptions);
    }

    @Test
    public void doFilter() throws Exception {
        filter.doFilter(request, response, filterChain);

        verify(filterChain).doFilter(request, response);

        verify(response).addHeader("X-XSS-Protection", xXssProtection);
        verify(response).addHeader("X-Content-Type-Options", xContentTypeOptions);
        verify(response).addHeader("X-Frame-Options", xFrameOptions);

        verify(response).addHeader("Access-Control-Allow-Methods", accessControlAllowMethods);
        verify(response).addHeader("Access-Control-Allow-Headers", accessControlAllowHeaders);
        verify(response).addHeader("Access-Control-Allow-Origin", accessControlAllowOrigin);
    }

}