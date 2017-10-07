package com.practise.cors.servlet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Pratik Ambani on 01/09/17.
 */

@Component
public class HttpHeaderSecurityFilter implements Filter {

    @Value("${httpHeaderSecurityFilter.accessControlAllowMethods:POST, GET, PUT, DELETE, HEAD, OPTIONS}")
    private String accessControlAllowMethods;

    @Value("${httpHeaderSecurityFilter.accessControlAllowOrigin:*}")
    private String accessControlAllowOrigin;

    @Value("${httpHeaderSecurityFilter.accessControlAllowHeaders:x-request-application, content-type}")
    private String accessControlAllowHeaders;

    @Value("${httpHeaderSecurityFilter.xFrameOptions:SAMEORIGIN}")
    private String xFrameOptions;

    @Value("${httpHeaderSecurityFilter.xXssProtection:0}")
    private String xXssProtection;

    @Value("${httpHeaderSecurityFilter.xContentTypeOptions:nosniff}")
    private String xContentTypeOptions;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Protection against Type 1 Reflected XSS attacks
        httpResponse.addHeader("X-XSS-Protection", xXssProtection);

        // Disabling browsers to perform risky mime sniffing
        httpResponse.addHeader("X-Content-Type-Options", xContentTypeOptions);

        // Protects your visitors against clickjacking attacks.
        httpResponse.addHeader("X-Frame-Options", xFrameOptions);

        // To allow any resource to access this resource
        httpResponse.addHeader("Access-Control-Allow-Origin", accessControlAllowOrigin);

        // Allow these methods
        httpResponse.addHeader("Access-Control-Allow-Methods", accessControlAllowMethods);

        // Allow these headers
        httpResponse.addHeader("Access-Control-Allow-Headers", accessControlAllowHeaders);

        //passes on request
        filterChain.doFilter(request, httpResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}