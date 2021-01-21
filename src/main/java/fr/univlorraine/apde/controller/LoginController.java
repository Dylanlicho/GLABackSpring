package fr.univlorraine.apde.controller;

import fr.univlorraine.apde.dao.IUserRepository;
import fr.univlorraine.apde.model.User;
import fr.univlorraine.apde.securityJWT.jwt.JwtUtils;
import fr.univlorraine.apde.securityJWT.payloads.JwtResponse;
import fr.univlorraine.apde.securityJWT.payloads.LoginRequest;
import fr.univlorraine.apde.securityJWT.payloads.MessageResponse;
import fr.univlorraine.apde.securityJWT.payloads.SignupRequest;
import fr.univlorraine.apde.securityJWT.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/auth/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest request){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername()));
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest request){
        // If user already exist we can't take it
        if(userRepository.existsByLogin(request.getLogin())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        // If user doesn't exist yet, we create an account
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordEncrypted = encoder.encode(request.getPassword());
        User user = new User(request.getFirstname(), request.getLastname(), request.getLogin(), request.getAddress(), passwordEncrypted);
        System.out.println("____________________________________________________");
        System.out.println(user.toString());
        System.out.println("____________________________________________________");
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully"));
    }

}
