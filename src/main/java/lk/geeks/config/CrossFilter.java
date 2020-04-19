package lk.geeks.config;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrossFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
//        httpServletResponse.setHeader("Access-Control-Allow-Origin","http://localhost:8100");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE,OPTION");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token, Cache-Control");
        httpServletResponse.setHeader("Access-Control-Expose-Headers", "xsrf-token");
        if ("OPTIONS".equals(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }

    }
}
