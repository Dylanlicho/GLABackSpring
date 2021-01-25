package fr.univlorraine.apde.securityJWT.jwt;

import fr.univlorraine.apde.securityJWT.service.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author DylanLICHO
 */
// Filter the requests
public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        try {
            // Extract jwt block and trash Bearer prefix
            String jwt = parseJwt(httpServletRequest);

            // If the jwt is valid
            if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
                // We extract the login
                String login = jwtUtils.getLoginFromJwtToken(jwt);

                // We find all the details about the user authenticated and create an Authentication Object
                System.out.println("DANS LE FILTER AVEC LE LOGIN: "+login);
                UserDetails userDetails = userDetailsService.loadUserByUsername(login);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, null);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                // We configure the security context thanks to Authentication Object
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }else{
                System.out.println("-----------------------------------------------------");
                System.out.println("Pas passé le filtre, jwt non valide ou null");
                System.out.println(jwt);
                System.out.println("-----------------------------------------------------");
            }
        } catch (Exception e) {
            logger.error("Cannot set user authentication: ", e);
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    // Extract the jwt from the header by removing Bearer prefix
    private String parseJwt(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7, headerAuth.length());
        }

        return null;
    }

}
