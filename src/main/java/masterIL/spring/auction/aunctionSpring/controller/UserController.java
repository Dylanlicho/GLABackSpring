package masterIL.spring.auction.aunctionSpring.controller;

import masterIL.spring.auction.aunctionSpring.dao.user.IUserRepository;
import masterIL.spring.auction.aunctionSpring.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserRepository dao;

    @GetMapping(value = "users")
    public Iterable<Users> findAll(){
        return dao.findAll();
    }

    @PostMapping(value = "addUser")
    public void addSerie(@RequestBody Users user){
        dao.save(user);
    }

}
