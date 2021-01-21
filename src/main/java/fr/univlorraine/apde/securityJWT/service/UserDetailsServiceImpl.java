package fr.univlorraine.apde.securityJWT.service;

import fr.univlorraine.apde.dao.IUserRepository;
import fr.univlorraine.apde.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    // User repository
    @Autowired
    IUserRepository userRepository;

    // Transaction to find the user, return an exception if user not founded
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException("User Not Found with login: \""+login+" \""));
        System.out.println("User found: "+user.getLogin() + " password : "+user.getPassword());
        return UserDetailsImpl.build(user);
    }
}
