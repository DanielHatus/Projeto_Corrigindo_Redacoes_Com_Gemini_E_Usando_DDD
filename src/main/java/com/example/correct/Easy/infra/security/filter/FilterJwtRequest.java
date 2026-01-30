package com.example.correct.Easy.infra.security.filter;

import com.example.correct.Easy.infra.exception.response.filter.ResponseEntryException;
import com.example.correct.Easy.infra.exception.typo.secundaries.security.HeaderIsIncorrect;
import com.example.correct.Easy.infra.security.implementations.UserDetailsServiceImpl;
import com.example.correct.Easy.infra.security.utils.GetEmailByPayload;
import com.example.correct.Easy.infra.security.validation.ValidateToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class FilterJwtRequest extends OncePerRequestFilter{

    private final ValidateToken validateToken;
    private final GetEmailByPayload getEmail;
    private final UserDetailsServiceImpl userDetailsServiceImpl;
    private final ResponseEntryException entryException;

    public FilterJwtRequest(ValidateToken validateToken, GetEmailByPayload getEmail, UserDetailsServiceImpl userDetailsServiceImpl, ResponseEntryException entryException) {
        this.validateToken = validateToken;
        this.getEmail = getEmail;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.entryException = entryException;
    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path=request.getServletPath();
        return path.startsWith("/api/auth/register")||
                path.startsWith("/api/auth/login");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       try{
       String header=getHederOrThrow(request);
       String token=getTokenByHeader(header);
       validateToken.execute(token);
       saveUserAuthenticatedInContextSecurity(token);
       filterChain.doFilter(request,response);
       }
       catch (AuthenticationException e){
         entryException.commence(request,response,e);
       }
    }

    private String getHederOrThrow(HttpServletRequest request){
        String header=request.getHeader("Authorization");
        if (header==null||!header.startsWith("Bearer ")){throw new HeaderIsIncorrect("o header da requisição está invalido. por favor tente novamente.");}
        return header;
    }

    private String getTokenByHeader(String header){
        return header.replace("Bearer ","");
    }

    private void saveUserAuthenticatedInContextSecurity(String token){
        String emailUserPayload=getEmail.execute(token);
        UserDetails userDetails=userDetailsServiceImpl.loadUserByUsername(emailUserPayload);
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }
}
