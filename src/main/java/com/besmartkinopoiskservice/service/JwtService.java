package com.besmartkinopoiskservice.service;

import com.besmartkinopoiskservice.domain.UserEntity;
import com.besmartkinopoiskservice.exception.AuthenticationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY = "WYU2bEVbF1LTKxuFO9sh/YvRLBOTwUkxrtMknNrtr2Gl4pDs5h+mV09SVUvK9oRw";

    public String extractUsername(String token) throws AuthenticationException {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) throws AuthenticationException {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }
    public String generateToken(UserEntity userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(Map<String, Object> extractClaims, UserEntity userDetails){
        return Jwts
                .builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) throws AuthenticationException {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) throws AuthenticationException {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) throws AuthenticationException {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) throws AuthenticationException {
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(getSignKey())
                    .build().parseClaimsJws(token)
                    .getBody();
        }
        catch (Exception e){
            throw new AuthenticationException(e.getMessage());
        }
    }

    private Key getSignKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
