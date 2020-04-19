package lk.geeks.controller;

import lk.geeks.dto.LoginDetailDTO;
import lk.geeks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/users")
/**
 * This is the API for the Control Users
 */
public class UserController {


    @Autowired
    private UserService userService;

    /**
     * Login Method
     * @param userName User Name of User
     * @param password Password of User
     * @return Login Details DTO
     */
    @GetMapping(value = "login/{userName}/{password}")
    public LoginDetailDTO signIn(@PathVariable("userName") String userName, @PathVariable("password") String password){
        return userService.login(userName,password);

    }


    @PostMapping(path = "/login")
    public Principal user(Principal principal){
        return principal;
    }

}
