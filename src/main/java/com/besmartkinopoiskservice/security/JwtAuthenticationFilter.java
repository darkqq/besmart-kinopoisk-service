package com.besmartkinopoiskservice.security;

import com.besmartkinopoiskservice.exception.AuthenticationException;
import com.besmartkinopoiskservice.service.JwtService;
import com.besmartkinopoiskservice.service.UserDetailsService;
import com.besmartkinopoiskservice.to.response.error.ExceptionResponseTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws IOException {
        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        String username = null;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            try {
                filterChain.doFilter(request, response);
            } catch (Exception e) {
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().print(new Gson().toJson(new ExceptionResponseTO(e.getMessage())));
                return;
            }
            return;
        }
        jwt = authHeader.substring(7);
        try {
            username = jwtService.extractUsername(jwt);
        } catch (AuthenticationException e) {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().print(new Gson().toJson(new ExceptionResponseTO(e.getMessage())));
            return;
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            try {
                if (jwtService.isTokenValid(jwt, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities()
                    );
                    authToken.setDetails(
                            new WebAuthenticationDetailsSource().buildDetails(request)
                    );
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            } catch (AuthenticationException e) {
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().print(new Gson().toJson(new ExceptionResponseTO(e.getMessage())));
                return;
            }
        }
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().print(new Gson().toJson(new ExceptionResponseTO(e.getMessage())));
            return;
        }
    }
}
