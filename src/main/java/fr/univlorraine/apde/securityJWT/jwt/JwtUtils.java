package fr.univlorraine.apde.securityJWT.jwt;

import fr.univlorraine.apde.securityJWT.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import java.util.Date;

// Some utilities for JWT
@Component
public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    // Extract JWT configuration from application.properties
    @Value("${apde.app.jwtSecret}")
    private String jwtSecret;

    @Value("${apde.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    // Generate a token
    public String generateJwtToken(Authentication authentication){
        UserDetailsImpl userAuthenticated = (UserDetailsImpl) authentication.getPrincipal();

        System.out.println("-----------------");
        System.out.println("generete Token: "+userAuthenticated);
        System.out.println("-----------------");

        return Jwts.builder()
                .setSubject((userAuthenticated.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    // Extract the login
    public String getLoginFromJwtToken(String token){
        System.out.println("-----------------");
        System.out.println("JWT: "+token);
        System.out.println("Extract body: "+Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody());
        System.out.println("Extract login: "+Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject());
        System.out.println("-----------------");
        System.out.println(Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject());
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    // Return true if the token given is valid, False otherwise
    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }

        return false;
    }

}
