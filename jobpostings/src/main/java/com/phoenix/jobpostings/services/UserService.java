package com.phoenix.jobpostings.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.phoenix.jobpostings.models.User;
import com.phoenix.jobpostings.repositories.UserRepository;

@Service
public class UserService {
    // adding the User repository as a dependency
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // CRUD METHODS
    
        // CREATE
        public User createUser(User b) {
            return userRepository.save(b);
        }
        // END OF CREATE

        // READ
        public List<User> allUsers() {
            return userRepository.findAll();
        }

        public User findUser(Long id) {
            Optional<User> optionalUser = userRepository.findById(id);
            if(optionalUser.isPresent()) {
                return optionalUser.get();
            } else {
                return null;
            }
        }
        // END OF READ

        // UPDATE
        public User updateUser(User b){
            return userRepository.save(b);
        }
        // END OF UPDATE

        // DELETE
        public void deleteUser(Long id){
            userRepository.deleteById(id);
        }
        // END OF DELETE
        
    // END OF CRUD METHODS
}