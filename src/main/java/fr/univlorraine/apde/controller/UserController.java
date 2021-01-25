package fr.univlorraine.apde.controller;

import fr.univlorraine.apde.dao.IUserRepository;
import fr.univlorraine.apde.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 *
 * @author DylanLICHO
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    private IUserRepository dao;

    @GetMapping(value = "users")
    public Iterable<User> findAll(){
        return dao.findAll();
    }

    @GetMapping(value = "user/{id}")
    public Optional<User> getUserById(@PathVariable Integer id){
        return dao.findById(id);
    }

    @GetMapping(value = "user/login/{login}")
    public Optional<User> getUserByLogin(@PathVariable String login){
        return dao.findByLogin(login);
    }

    @GetMapping(value = "existUser/{id}")
    public boolean existUserById(@PathVariable Integer id){return dao.existsById(id);}

    @GetMapping(value = "countUsers")
    public long count(){return dao.count();}

    @PostMapping(value = "addUser")
    public void addUser(@RequestBody User user){
        dao.save(user);
    }

    @DeleteMapping(value = "deleteUserByUser")
    public void deleteUserByUser(@RequestBody User user){ dao.delete(user);}

    @DeleteMapping(value = "deleteUserById/{id}")
    public void deleteUserById(@PathVariable Integer id){ dao.deleteById(id);}


}
