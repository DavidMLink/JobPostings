package com.phoenix.jobpostings.controllers;

import java.util.List;

import com.phoenix.jobpostings.models.User;
import com.phoenix.jobpostings.services.UserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCRUD {
    private final UserService userService;
    public UserCRUD(UserService userService){
        this.userService = userService;
    }
    
    // CRUD

        // CREATE
            @RequestMapping(value="/api/users", method=RequestMethod.POST)
            public User create(@RequestParam(value="email") String email, @RequestParam(value="password") String password, @RequestParam(value="firstname") String firstname, @RequestParam(value="lastname") String lastname) { 
                User user = new User( email, password, firstname, lastname ); 
                return userService.createUser(user); 
            } 
        
        // READ 
            // Specific Table 
            @RequestMapping("/api/users/{id}") 
            public User show(@PathVariable("id") Long id) { 
                User user = userService.findUser(id); 
                return user; 
            } 
            // All Tables 
            @RequestMapping("/api/users") 
            public List<User> index() { 
                return userService.allUsers(); 
            } 
        
        // UPDATE 
            @RequestMapping(value="/api/users/{id}", method=RequestMethod.PUT) 
            public User update(@PathVariable("id") Long id, @RequestParam(value="email") String email,  @RequestParam(value="password") String password,  @RequestParam(value="firstname") String firstname,  @RequestParam(value="lastname") String lastname) { 
                User user = new User(id, email, password, firstname, lastname ); 
                User userUpdated = userService.updateUser(user); 
                return userUpdated; 
            } 
        // DELETE 
            @RequestMapping(value="/api/users/{id}", method=RequestMethod.DELETE) 
            public void destroy(@PathVariable("id") Long id) { 
                userService.deleteUser(id); 
            } 
    // END OF CRUD 
} 
