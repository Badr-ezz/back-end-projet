package com.example.carsProject.service;



import com.example.carsProject.entity.Utilisateur;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.*;
import java.util.function.Function;

@Service
public class JWTService {

    private static final Key SECRET_KEY = Keys.hmacShaKeyFor("tt/tMaTsPvG5cy1c1EhKhKEb22Pr69j55n5MxEAIyUU=".getBytes());

    // Token blacklist for invalidated tokens
    private final List<String> tokenBlacklist = new ArrayList<>();

    // must explain
    public String generateToken (Utilisateur user) {
        Map<String, Object> claims = new HashMap<>();  // to store other infos that you want to add in the jwt token playload (role,permission ,...)
        claims.put("FirstName",user.getFirstName()) ;
        claims.put("LastName",user.getLastName()) ;
        claims.put("role",user.getRole()) ;
        claims.put("id",user.getId()) ;

        return Jwts.builder()  // initialise the jwts
                .claims() // indicate that the claims will be added
                .add(claims) // add the claims
                .subject(user.getEmail()) // determine who this token belong to , it can be the id or the email , etc ....
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 30 * 60 * 1000))
                .and()
                .signWith(SECRET_KEY) // the algo that is used to create the token
                .compact()  // convert the jtw into a url-safe String format
                ;
    }

    private SecretKey getSecretKey() {
        return (SecretKey) SECRET_KEY;
    }

    //////////////////// code added
    public String extractUserName(String token) {
        // extract the username from jwt token
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);

        if (isTokenBlacklisted(token)) {
            return false;
        }

        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Logout method: blacklist the token
    public String logout(String token) {
        if (token != null) {
            tokenBlacklist.add(token);
            return "Token invalidated successfully.";
        }
        return "Invalid token.";
    }



    // Check if a token is blacklisted
    public boolean isTokenBlacklisted(String token) {
        return tokenBlacklist.contains(token);
    }
}

